package org.assignment.app.controller;

import org.assignment.app.constant.BeerStatus;
import org.assignment.app.form.BeerForm;
import org.assignment.common.CopyProperties;
import org.assignment.common.Messages;
import org.assignment.domain.entity.Beer;
import org.assignment.domain.service.BeerService;
import org.assignment.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	CategoryService categoryService;

	/**
	 * Set up form
	 * @return BeerForm
	 */
	@ModelAttribute
	public BeerForm setUpForm() {
		BeerForm beerForm = new BeerForm();

		// Set default beer status
		beerForm.setIsArchived(false);
		return beerForm;
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
	 * @param model - add list of category, status
	 * @return register page
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String displayRegister(BeerForm beerForm, Model model) {
		addCommon(model);
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
			addCommon(model);
			return REGISTER_PAGE_PATH;
		}

		try {
			Beer beer = new Beer();

			// Copy data from form to entity
			CopyProperties.copyProperties(beerForm, beer);

			// Register beer
			beerService.save(beer);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return REGISTER_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute(Messages.success().message("success.register"));
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Display update page
	 * @param beerId
	 * @param beerForm
	 * @param model
	 * @return UPDATE_PAGE_PATH
	 */
	@RequestMapping(value = "update/{beerId}", method = RequestMethod.GET)
	public String displayUpdate(@PathVariable("beerId") Long beerId, BeerForm beerForm, Model model) {
		try {
			Beer beer = beerService.findByBeerId(beerId);

			CopyProperties.copyProperties(beer, beerForm);

			addCommon(model);
		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return UPDATE_PAGE_PATH;
		}

		return UPDATE_PAGE_PATH;
	}

	/**
	 * Process update
	 * @param beerForm
	 * @param bindingResult
	 * @param model
	 * @param redirectAttributes
	 * @return UPDATE_PAGE_PATH if has error else REDIRECT_INDEX_REQUEST
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdate(@Validated BeerForm beerForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		// If form has errors
		if (bindingResult.hasErrors()) {
			return UPDATE_PAGE_PATH;
		}

		try {
			Beer beer = beerService.findByBeerId(beerForm.getBeerId());

			// Copy data from form to entity
			CopyProperties.copyProperties(beerForm, beer);

			// Update category
			beerService.save(beer);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return UPDATE_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute(Messages.success().message("success.update"));
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Delete a beer
	 * @param beerId
	 * @param model
	 * @param attributes
	 * @return INDEX_PAGE_PATH if has error else REDIRECT_INDEX_REQUEST
	 */
	@RequestMapping(value="/delete/{beerId}", method=RequestMethod.GET)
	public String delete(@PathVariable("beerId") Long beerId, Model model, RedirectAttributes attributes) {
		try {

			// Delete a beer
			beerService.delete(beerId);
		} catch (Exception ex) {
			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return INDEX_PAGE_PATH;
		}

		attributes.addFlashAttribute(Messages.success().message("success.delete"));
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Add common
	 * @param model
	 * @return addCommon
	 */
	private Model addCommon(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("beerStatus", BeerStatus.values());
		return model;
	}
}
