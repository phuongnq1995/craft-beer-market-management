package org.assignment.app.controller.api;

import org.assignment.app.form.ClientForm;
import org.assignment.common.ErrorResponse;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.util.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq 
 * JwtController
 */
@Controller
@RequestMapping(value = "api/client")
public class RestClientController {

	@Autowired
	JwtService jwtService;

	/**
	 * Get token
	 * @param client - username and password
	 * @return token
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> generateToken(@RequestBody(required=true) ClientForm client) {

		HttpStatus httpStatus = null;
		Object result = null;

		if (jwtService.checkExistClient(client.getClientId(), client.getClientSecret())) {
			result = jwtService.generateToken(client.getClientId(), TokenType.CLIENT);
			httpStatus = HttpStatus.OK;
		} else {
			result = new ErrorResponse("Wrong userId and password", HttpStatus.BAD_REQUEST);
			httpStatus = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(result, httpStatus);
	}
}
