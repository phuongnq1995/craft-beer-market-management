package org.assignment.app.controller;

import org.assignment.app.form.CategoryForm;
import org.assignment.common.CopyProperties;
import org.assignment.common.Messages;
import org.assignment.domain.entity.Category;
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
	public String displayRegister(CategoryForm categoryForm, Model model) {
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
			return displayRegister(categoryForm, model);
		}

		try {
			Category category = new Category();

			// Copy data from form to entity
			CopyProperties.copyProperties(categoryForm, category);

			// Register category
			categoryService.save(category);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return displayRegister(categoryForm, model);
		}

		redirectAttributes.addFlashAttribute(Messages.success().message("success.register"));
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Display update page
	 * 
	 * @param categoryId - Category id
	 * @param categoryForm
	 * @param model
	 * @return update page
	 * @throws Exception 
	 */
	@RequestMapping(value = "update/{categoryId}", method = RequestMethod.GET)
	public String displayUpdate(@PathVariable("categoryId") Long categoryId, CategoryForm categoryForm, Model model) {
		try {
			Category category = categoryService.findByCategoryId(categoryId);
	
			CopyProperties.copyProperties(category, categoryForm);
		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return UPDATE_PAGE_PATH;
		}
		return UPDATE_PAGE_PATH;
	}

	/**
	 * Process update
	 * @param categoryForm
	 * @param bindingResult
	 * @param model
	 * @param redirectAttributes
	 * @return UPDATE_PAGE_PATH if has error else REDIRECT_INDEX_REQUEST
	 * @throws Exception 
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String processUpdate(@Validated CategoryForm categoryForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		// If form has errors
		if (bindingResult.hasErrors()) {
			return UPDATE_PAGE_PATH;
		}

		try {
			Category category = categoryService.findByCategoryId(categoryForm.getCategoryId());

			// Copy data from form to entity
			CopyProperties.copyProperties(categoryForm, category);

			// Update category
			categoryService.save(category);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute(Messages.error().message(ex.getMessage()));
			return UPDATE_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute(Messages.success().message("success.update"));
		return REDIRECT_INDEX_REQUEST;
	}

	/**
	 * Delete category
	 * @param categoryId - category id
	 * @param model - for messages errors
	 * @param attributes - for messages success
	 * @return INDEX_PAGE_PATH if has error else REDIRECT_INDEX_REQUEST
	 */
	@RequestMapping(value="/delete/{categoryId}", method=RequestMethod.GET)
	public String delete(@PathVariable("categoryId") Long categoryId, Model model, RedirectAttributes attributes) {
		try {

			// Delete category
			categoryService.delete(categoryId);
		} catch (Exception ex) {
			// Message exception
			attributes.addFlashAttribute(Messages.error().message("meesage.category.delete"));
			return REDIRECT_INDEX_REQUEST;
		}

		attributes.addFlashAttribute(Messages.success().message("success.delete"));
		return REDIRECT_INDEX_REQUEST;
	}
}
