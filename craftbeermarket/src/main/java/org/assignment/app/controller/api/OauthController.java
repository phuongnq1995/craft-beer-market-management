package org.assignment.app.controller.api;

import org.assignment.app.form.OauthForm;
import org.assignment.common.CopyProperties;
import org.assignment.domain.entity.Oauth;
import org.assignment.domain.service.JwtService;
import org.assignment.domain.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq OauthController
 */
@Controller
@RequestMapping(value = "oauth")
public class OauthController {

	@Autowired
	JwtService jwtService;

	@Autowired
	OauthService oauthService;

	@RequestMapping(value="login")
	@ResponseBody
	public ResponseEntity<String> getToken(@RequestBody OauthForm oauthForm) {
		String result = "";
		HttpStatus httpStatus = null;
		Oauth oauth = new Oauth();
		CopyProperties.copyProperties(oauthForm, oauth);
		if (oauthService.checkExistClient(oauth)) {
			result = jwtService.generateTokenLogin(oauth);
			httpStatus = HttpStatus.OK;
		} else {
			result = "Wrong userId and password";
			httpStatus = HttpStatus.BAD_REQUEST;	
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}
