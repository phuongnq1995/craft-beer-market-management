package org.assignment.app.controller.api;

import org.assignment.app.form.ClientForm;
import org.assignment.domain.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq 
 * JwtController
 */
@Controller
@RequestMapping(value = "api/oauth")
public class JwtController {

	@Autowired
	JwtService jwtService;

	/**
	 * Get token
	 * @param client - username and password
	 * @return token
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public ResponseEntity<String> generateToken(@RequestBody(required=true) ClientForm client) {
		String result = "";
		HttpStatus httpStatus = null;

		if (jwtService.checkExistUser(client.getUsername(), client.getPassword())) {
			result = jwtService.generateTokenLogin(client.getUsername());
			httpStatus = HttpStatus.OK;
		} else {
			result = "Wrong userId and password";
			httpStatus = HttpStatus.BAD_REQUEST;	
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
