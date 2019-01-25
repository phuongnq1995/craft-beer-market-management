package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.entity.Beer;
import org.assignment.domain.model.BeerModel;
import org.assignment.domain.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * Beer service implement
 * Handle business beer
 */
/**
 * @author phuongnq
 *
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
	public List<BeerModel> getAll() {
		return beerRepository.getAllBeer();
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
	public Beer findByBeerId(Long beerId) {
		return beerRepository.findOne(beerId);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.BeerService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long beerId) {
		beerRepository.delete(beerId);
	}

}
