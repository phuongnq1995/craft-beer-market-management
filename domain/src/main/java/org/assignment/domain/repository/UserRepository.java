package org.assignment.domain.repository;

import org.assignment.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * Query data from table "user"
 */
public interface UserRepository extends JpaRepository<User, String> {

}
