package org.assignment.app.controller.api;

import javax.servlet.http.HttpServletResponse;

import org.assignment.app.form.AuthForm;
import org.assignment.app.form.ConsumeForm;
import org.assignment.app.form.LoginForm;
import org.assignment.common.CopyProperties;
import org.assignment.domain.entity.History;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.TokenInfo;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.service.BeerService;
import org.assignment.domain.service.CustomerService;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.util.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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

	@Autowired
	JwtService jwtService;

	@Autowired
	BeerService beerService;

	/**
	 * Register
	 * @param authForm
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
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

	/**
	 * Consume a beer
	 * @param user
	 * @param consumeForm
	 * @param response
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value="consume", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> consume(@RequestBody @Validated ConsumeForm consumeForm, 
			HttpServletResponse response) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserCustomDetails userDetails = (UserCustomDetails) authentication.getPrincipal();

		if(beerService.findByBeerId(consumeForm.getBeerId()) == null) {
			throw new Exception("comsume.notfound.beerId"); 
		}
		History history = new History(userDetails.getUsername(), consumeForm.getBeerId());
		history = customerService.addHistory(history);

		return new ResponseEntity<>(history, HttpStatus.CREATED);
	}

	/**
	 * Get token
	 * @param customer - username and password
	 * @return token
	 * @throws Exception 
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
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
