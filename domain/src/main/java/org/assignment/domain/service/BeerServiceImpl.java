package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.entity.Beer;
import org.assignment.domain.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#getAll()
	 */
	@Override
	public List<Beer> getAll() {
		return beerRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#save(org.assignment.domain.entity.Beer)
	 */
	@Override
	public void save(Beer beer) {
		beerRepository.save(beer);
	}

}
