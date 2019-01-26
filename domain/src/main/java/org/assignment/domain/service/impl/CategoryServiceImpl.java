package org.assignment.domain.service.impl;

import java.util.List;

import org.assignment.domain.entity.Category;
import org.assignment.domain.repository.CategoryRepository;
import org.assignment.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * Category service handle business
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CategoryService#getAll()
	 */
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CategoryService#register(org.assignment.domain.entity.Category)
	 */
	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CategoryService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long categoryId) throws Exception {
		if(categoryRepository.existAnyBeer(categoryId) == 1) {
			throw new Exception("need to delete all of beer in this category");
		}
		categoryRepository.delete(categoryId);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.CategoryService#findByCategoryId(java.lang.Long)
	 */
	@Override
	public Category findByCategoryId(Long categoryId) {
		return categoryRepository.findOne(categoryId);
	}

}
