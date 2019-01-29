package org.assignment.domain.service.impl;

import java.util.List;

import org.assignment.domain.dto.BeerAvailableDTO;
import org.assignment.domain.dto.BeerDTO;
import org.assignment.domain.dto.HistoryDTO;
import org.assignment.domain.entity.Beer;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.model.UserPassport;
import org.assignment.domain.repository.BeerRepository;
import org.assignment.domain.repository.HistoryRepository;
import org.assignment.domain.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * Beer service implement
 * Handle business beer
 */
@Service
@Transactional
public class BeerServiceImpl implements BeerService {

	@Autowired
	BeerRepository beerRepository;

	@Autowired
	HistoryRepository historyRepository;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#getAll()
	 */
	@Override
	public List<BeerDTO> getAll() {
		return beerRepository.getAllBeer();
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#getBeerByStatus(java.lang.Boolean, org.springframework.security.core.Authentication)
	 */
	@Override
	public Object getBeerByStatus(Boolean isArchived, Authentication authentication) {
		List<BeerAvailableDTO> beers = beerRepository.getBeerByStatus(isArchived);

		// If user customer
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetails user = (UserCustomDetails) authentication.getPrincipal();

			// Select history
			List<HistoryDTO> histories = historyRepository.findHistoryByUser(user.getUsername());
			return new UserPassport(beers, histories);
		}

		// Return beers available
		return beers;
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#save(org.assignment.domain.entity.Beer)
	 */
	@Override
	public void save(Beer beer) {
		beerRepository.save(beer);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#findByBeerId(java.lang.Long)
	 */
	@Override
	public Beer findByBeerId(Long beerId) throws Exception {
		Beer beer = beerRepository.findOne(beerId);
		if(beer == null) {
			throw new Exception("Beer not found !");
		}
		return beer;
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long beerId) {
		beerRepository.delete(beerId);
	}

}
