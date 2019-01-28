package org.assignment.domain.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.assignment.domain.entity.Role;
import org.assignment.domain.entity.User;
import org.assignment.domain.repository.RoleRepository;
import org.assignment.domain.repository.UserRepository;
import org.assignment.domain.service.UserService;
import org.assignment.domain.util.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * User service implement for process user business
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.UserService#register(org.assignment.domain.entity.User)
	 */
	public void registerAdmin(User user) {
		registerUser(user, ApplicationRole.ADMIN_ROLE);
	}

	public void registerCustomer(User user) {
		registerUser(user, ApplicationRole.ROLE_CUSTOMER);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.UserService#exists(java.lang.String)
	 */
	public boolean exists(String username) {
		return userRepository.exists(username);
	}

	/**
	 * Register User
	 * @param user
	 * @param roleName
	 */
	private void registerUser(User user, ApplicationRole roleName) {

		// Select role by admin's role name
		Role role = roleRepository.findByName(String.valueOf(roleName));
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);

		// Set role to user
		user.setRoles(roles);

		// Encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// omitted
		userRepository.save(user);
	}
}
