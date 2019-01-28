package org.assignment.app.controller.api;

import java.util.List;

import org.assignment.common.BeerStatus;
import org.assignment.domain.dto.BeerAvailableDTO;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * getBeerAvailabel
	 * @return list of beers available
	 */
	@RequestMapping
	public @ResponseBody List<BeerAvailableDTO> getBeerAvailabel(@AuthenticationPrincipal UserCustomDetails user) {
		// Get list of beers available
		List<BeerAvailableDTO> listBeers = beerService.getBeerByStatus(BeerStatus.AVAILABLE.getValue(), user);
		return listBeers;
	}

}
