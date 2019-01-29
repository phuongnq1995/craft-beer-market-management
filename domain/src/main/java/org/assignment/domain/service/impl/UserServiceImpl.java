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
		registerUser(user, ApplicationRole.ROLE_ADMIN);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.UserService#registerCustomer(org.assignment.domain.entity.User)
	 */
	public void registerCustomer(User user) {
		registerUser(user, ApplicationRole.ROLE_CUSTOMER);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.UserService#exists(java.lang.String)
	 */
	public boolean exists(String username) {
		return userRepository.exists(username);
	}

	/* (non-Javadoc)
	 * @see org.assignment.domain.service.UserService#checkExistUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean checkExistUser(String username, String password) {

		if(username == null || username.isEmpty()) {
			return false;
		}

		User user = userRepository.findOne(username);
		if(user == null || !passwordEncoder.matches(password, user.getPassword())) {
			return false;
		}
		return true;
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
