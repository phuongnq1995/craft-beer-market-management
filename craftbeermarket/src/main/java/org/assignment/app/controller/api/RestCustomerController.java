package org.assignment.app.controller.api;

import org.assignment.app.form.AuthForm;
import org.assignment.app.form.api.ConsumeForm;
import org.assignment.common.CopyProperties;
import org.assignment.common.ErrorResponse;
import org.assignment.domain.entity.History;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="api/customer")
public class RestCustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value="register", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> register(@RequestBody(required=true) AuthForm authForm) {

		HttpStatus httpStatus = null;
		Object result = null;
		try {
			User user = new User();

			// Copy data from form to entity
			CopyProperties.copyProperties(authForm, user);

			// Register user
			// Return token info
			result = customerService.register(user);
			httpStatus = HttpStatus.OK;
		} catch (Exception ex) {

			result = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(result, httpStatus);
	}

	@RequestMapping(value="consume", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> consume(@AuthenticationPrincipal UserCustomDetails user,
			@RequestBody(required=true) ConsumeForm consumeForm) {

		HttpStatus httpStatus = null;
		Object result = null;
		try {

			History history = new History(user.getUsername(), consumeForm.getBeerId());

			customerService.addHistory(history);
			// Register user
			// Return token info
			httpStatus = HttpStatus.OK;
		} catch (Exception ex) {

			result = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(result, httpStatus);
	}
}
