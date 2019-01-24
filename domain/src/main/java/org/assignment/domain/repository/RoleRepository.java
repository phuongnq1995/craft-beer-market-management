package org.assignment.domain.repository;

import org.assignment.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Phuongnq
 * Query data from table "role"
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

	/**
	 * Find Role by role name
	 * @param roleName - the role name
	 * @return Role
	 */
	Role findByName(String roleName);

}
