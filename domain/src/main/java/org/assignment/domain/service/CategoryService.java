package org.assignment.domain.service;

import java.util.List;

import org.assignment.domain.entity.Category;

/**
 * @author Phuongnq
 * CategoryService interface
 */
public interface CategoryService {

	/**
	 * Get all category
	 * @return List<Category> in database
	 */
	List<Category> getAll();

	/**
	 * Register a category
	 * @param category
	 */
	void save(Category category);

	/**
	 * Delete a category
	 * @param categoryId
	 * @throws Exception 
	 */
	void delete(Long categoryId) throws Exception;

	/**
	 * Select category by categoryId
	 * @param categoryId
	 * @return Category
	 */
	Category findByCategoryId(Long categoryId);

}
