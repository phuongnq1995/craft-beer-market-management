package org.assignment.app.controller.api;

import javax.servlet.http.HttpServletResponse;

import org.assignment.app.form.AuthForm;
import org.assignment.app.form.api.ConsumeForm;
import org.assignment.common.CopyProperties;
import org.assignment.common.HttpResponse;
import org.assignment.domain.entity.History;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq
 * RestCustomerController
 */
@Controller
@RequestMapping(value="api/customer")
public class RestCustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * Register
	 * @param authForm
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> register(@RequestBody(required=true) AuthForm authForm) {

		HttpStatus httpStatus = null;
		HttpResponse result = null;
		try {
			User user = new User();

			// Copy data from form to entity
			CopyProperties.copyProperties(authForm, user);

			// Register user
			// Return token info
			customerService.register(user);
			result = new HttpResponse("Create success !", HttpStatus.CREATED);
			httpStatus = HttpStatus.CREATED;
		} catch (Exception ex) {

			result = new HttpResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(result, httpStatus);
	}

	/**
	 * Consume a beer
	 * @param user
	 * @param consumeForm
	 * @param response
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value="consume", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> consume(@RequestBody(required=true) ConsumeForm consumeForm, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HttpStatus httpStatus = null;
		Object result = null;
		try {
			UserCustomDetails userDetails = (UserCustomDetails) authentication.getPrincipal();

			History history = new History(userDetails.getUsername(), consumeForm.getBeerId());

			customerService.addHistory(history);
			// Register user
			// Return token info
			httpStatus = HttpStatus.CREATED;
		} catch (Exception ex) {

			result = new HttpResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(result, httpStatus);
	}
}
