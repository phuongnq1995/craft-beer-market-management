package org.assignment.app.controller;

import org.assignment.app.form.BeerForm;
import org.assignment.domain.entity.Beer;
import org.assignment.domain.service.BeerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Phuongnq
 * Beer controller
 */
@Controller
@RequestMapping(value="beer")
public class BeerController {

	private static final String REDIRECT_INDEX_REQUEST = "redirect:/beer";
	private static final String INDEX_PAGE_PATH = "beer/index";
	private static final String REGISTER_PAGE_PATH = "beer/register";
	private static final String UPDATE_PAGE_PATH = "beer/update";

	@Autowired
	BeerService beerService;
	
	/**
	 * Set up form
	 * @return BeerForm
	 */
	@ModelAttribute
	public BeerForm setUpForm() {
		return new BeerForm();
	}

	/**
	 * List beer
	 * 
	 * @param model : send data to view
	 * @return index page
	 */
	@RequestMapping
	public String index(Model model) {
		model.addAttribute("beers", beerService.getAll());
		return INDEX_PAGE_PATH;
	}


	/**
	 * Display register a beer
	 * 
	 * @param beerForm
	 * @return register page
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String displayRegister(BeerForm beerForm) {
		return REGISTER_PAGE_PATH;
	}

	/**
	 * Register a beer
	 * 
	 * @param beerForm
	 * @param bindingResult
	 * @param model
	 * @param redirectAttributes
	 * @return Register page if has error else index page
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegister(@Validated BeerForm beerForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		// If form has errors
		if (bindingResult.hasErrors()) {
			return REGISTER_PAGE_PATH;
		}

		try {
			Beer beer = new Beer();

			// Copy data from form to entity
			BeanUtils.copyProperties(beerForm, beer);

			// Register beer
			beerService.save(beer);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute("message", ex.getMessage());
			return REGISTER_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute("message", "register success !");
		return REDIRECT_INDEX_REQUEST;
	}
}
