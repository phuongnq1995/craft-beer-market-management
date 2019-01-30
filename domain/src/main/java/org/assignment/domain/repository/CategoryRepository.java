package org.assignment.domain.repository;

import org.assignment.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Phuongnq
 * Query data from table "category"
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

	/**
	 * Exist any beer
	 * {@code META-INF/jpa/category-orm.xml} file.
	 * @param categoryId
	 * @return true if exist else false
	 */
	Boolean existAnyBeer(@Param("categoryId") Long categoryId);

}
