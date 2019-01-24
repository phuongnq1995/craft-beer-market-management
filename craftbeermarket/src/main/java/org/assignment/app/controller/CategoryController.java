package org.assignment.app.controller;

import org.assignment.app.form.CategoryForm;
import org.assignment.domain.entity.Category;
import org.assignment.domain.service.CategoryService;
import org.springframework.beans.BeanUtils;
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
 * @author Phuongnq Category controller handler
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController {

	private static final String REDIRECT_INDEX_REQUEST = "redirect:/category";
	private static final String INDEX_PAGE_PATH = "category/index";
	private static final String REGISTER_PAGE_PATH = "category/register";
	private static final String UPDATE_PAGE_PATH = "category/update";

	@Autowired
	CategoryService categoryService;

	/**
	 * Set up form
	 * @return CategoryForm
	 */
	@ModelAttribute
	public CategoryForm setUpForm() {
		return new CategoryForm();
	}

	/**
	 * List category
	 * 
	 * @param model : send data to view
	 * @return index page
	 */
	@RequestMapping
	public String index(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return INDEX_PAGE_PATH;
	}

	/**
	 * Display register a category
	 * 
	 * @param categoryForm
	 * @return register page
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String displayRegister(CategoryForm categoryForm) {
		return REGISTER_PAGE_PATH;
	}

	/**
	 * Register a category
	 * 
	 * @param categoryForm
	 * @param bindingResult
	 * @param model
	 * @param redirectAttributes
	 * @return Register page if has error else index page
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegister(@Validated CategoryForm categoryForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		// If form has errors
		if (bindingResult.hasErrors()) {
			return REGISTER_PAGE_PATH;
		}

		try {
			Category category = new Category();

			// Copy data from form to entity
			BeanUtils.copyProperties(categoryForm, category);

			// Register category
			categoryService.save(category);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute("message", ex.getMessage());
			return REGISTER_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute("message", "register success !");
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Display update page
	 * 
	 * @param categoryId - Category id
	 * @param categoryForm
	 * @param model
	 * @return update page
	 */
	@RequestMapping(value = "update/{categoryId}", method = RequestMethod.GET)
	public String displayUpdate(@PathVariable("categoryId") Long categoryId, CategoryForm categoryForm, Model model) {
		Category category = categoryService.findByCategoryId(categoryId);

		BeanUtils.copyProperties(category, categoryForm);

		return UPDATE_PAGE_PATH;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdate(@Validated CategoryForm categoryForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		// If form has errors
		if (bindingResult.hasErrors()) {
			return UPDATE_PAGE_PATH;
		}

		try {
			Category category = new Category();

			// Copy data from form to entity
			BeanUtils.copyProperties(categoryForm, category);

			// Update category
			categoryService.save(category);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute("message", ex.getMessage());
			return UPDATE_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute("message", "update success !");
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Delete category
	 * @param categoryId - category id
	 * @param model - for messages errors
	 * @param attributes - for messages success
	 * @return index page
	 */
	@RequestMapping(value="/delete/{categoryId}", method=RequestMethod.GET)
	public String delete(@PathVariable("categoryId") Long categoryId, Model model, RedirectAttributes attributes) {
		try {

			// Delete category
			categoryService.delete(categoryId);
		} catch (Exception ex) {
			// Message exception
			model.addAttribute("message", ex.getMessage());
			return INDEX_PAGE_PATH;
		}

		attributes.addFlashAttribute("message", "delete success !");
		return REDIRECT_INDEX_REQUEST;
	}
}
