package org.assignment.app.controller.api;

import javax.servlet.http.HttpServletResponse;

import org.assignment.app.form.ConsumeForm;
import org.assignment.domain.entity.Beer;
import org.assignment.domain.entity.History;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.service.BeerService;
import org.assignment.domain.service.CustomerService;
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
	BeerService beerService;

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
		Beer beer = null;
		try {
			beer = beerService.findByBeerId(consumeForm.getBeerId());
		} catch (Exception e) {
			// Not found beer
			throw new Exception("comsume.notfound.beerId"); 
		}
		History history = new History(userDetails.getUsername(), beer.getBeerId());
		history = customerService.addHistory(history);

		return new ResponseEntity<>(history, HttpStatus.CREATED);
	}

}
