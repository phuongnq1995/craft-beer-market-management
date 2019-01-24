package org.assignment.domain.repository;

import org.assignment.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * Query data from table "category"
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
