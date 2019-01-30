package org.assignment.app.controller.api;

import org.assignment.app.form.ClientForm;
import org.assignment.app.form.LoginForm;
import org.assignment.domain.service.CustomerService;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.util.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq 
 * JwtController
 */
@Controller
@RequestMapping(value = "api/login")
public class RestLoginController {

	@Autowired
	JwtService jwtService;

	@Autowired
	CustomerService customerService;

	/**
	 * Get token
	 * @param client - clientId and clientSecret
	 * @return token
	 * @throws Exception 
	 */
	@RequestMapping(value="client", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> generateToken(@RequestBody @Validated ClientForm client) throws Exception {

		HttpStatus httpStatus = null;
		Object result = null;

		if (jwtService.checkExistClient(client.getClientId(), client.getClientSecret())) {
			result = jwtService.generateToken(client.getClientId(), TokenType.CLIENT);
			httpStatus = HttpStatus.OK;
		} else {
			throw new Exception("message.clientError");
		}
		return new ResponseEntity<>(result, httpStatus);
	}

	/**
	 * Get token
	 * @param customer - username and password
	 * @return token
	 * @throws Exception 
	 */
	@RequestMapping(value="customer", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> generateToken(@RequestBody @Validated LoginForm loginForm) throws Exception {
		Object result = null;

		if (customerService.checkExistCustomer(loginForm.getUsername(), loginForm.getPassword())) {

			result = jwtService.generateToken(loginForm.getUsername(), TokenType.CUSTOMER);
		} else {

			throw new Exception("message.loginError");
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
