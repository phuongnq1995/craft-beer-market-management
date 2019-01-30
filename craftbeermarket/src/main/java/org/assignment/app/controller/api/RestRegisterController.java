package org.assignment.app.controller.api;

import org.assignment.app.form.AuthForm;
import org.assignment.app.validator.AuthValidator;
import org.assignment.common.CopyProperties;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.TokenInfo;
import org.assignment.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq
 * RestRegisterController
 */
@Controller
@RequestMapping("api/register")
public class RestRegisterController {

	@Autowired
	CustomerService customerService;

	@Autowired
	AuthValidator authValidator;

	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(authValidator);
	}

	/**
	 * Register
	 * @param authForm
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value="customer", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> register(@RequestBody @Validated AuthForm authForm) throws Exception {
		User user = new User();

		// Copy data from form to entity
		CopyProperties.copyProperties(authForm, user);

		// Register user
		// Return token info
		TokenInfo result = customerService.register(user);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
