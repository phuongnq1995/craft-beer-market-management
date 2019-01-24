package org.assignment.app.controller;

import org.assignment.app.form.AuthForm;
import org.assignment.app.validator.AuthValidator;
import org.assignment.domain.entity.User;
import org.assignment.domain.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Phuongnq
 * Authentication and Authorization controller
 */
@Controller
@RequestMapping(value="auth")
public class AuthController {

	private static final String REDIRECT_HOME_REQUEST = "redirect:/";
	private static final String LOGIN_PAGE_PATH = "auth/loginForm";
	private static final String REGISTER_PAGE_PATH = "auth/registerForm";

	@Autowired
	AuthValidator authValidator;

	@Autowired
	UserService userService;

	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(authValidator);
	}

	@ModelAttribute
	public AuthForm setupForm() {
		return new AuthForm();
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return LOGIN_PAGE_PATH;
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return REGISTER_PAGE_PATH;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegistration(@Validated AuthForm authForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {
		// If form has errors
		if (bindingResult.hasErrors()) {
			return REGISTER_PAGE_PATH;
		}

		try {
			User user = new User();

			// Copy data from form to entity
			BeanUtils.copyProperties(authForm, user);

			// Register user
			userService.register(user);

		} catch (Exception ex) {

			// Message exception
			model.addAttribute("message", ex.getMessage());
			return REGISTER_PAGE_PATH;
		}

		redirectAttributes.addFlashAttribute("message", "register success");
		return REDIRECT_HOME_REQUEST;
	}
}
