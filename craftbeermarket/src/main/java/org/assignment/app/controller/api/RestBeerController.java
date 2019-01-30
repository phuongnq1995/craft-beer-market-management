package org.assignment.app.controller.api;

import org.assignment.app.constant.BeerStatus;
import org.assignment.domain.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Phuongnq
 * RestBeerController
 */
@Controller
@RequestMapping(value="api/beer")
public class RestBeerController {

	@Autowired
	BeerService beerService;

	/**
	 * Get beer available
	 * @return list of beers available
	 */
	@RequestMapping
	@ResponseBody
	public ResponseEntity<Object> getBeerAvailabel(
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="10") int size) throws Exception {

		// Authentication if logged else null
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Pageable pageable = new PageRequest(page, size);
		// Get list of beers available
		Object listBeers = beerService.getBeerByStatus(BeerStatus.AVAILABLE.getValue(), authentication, pageable);
		return new ResponseEntity<>(listBeers, HttpStatus.OK);
	}

}
