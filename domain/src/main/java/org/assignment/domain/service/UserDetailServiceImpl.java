package org.assignment.domain.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.assignment.domain.entity.Role;
import org.assignment.domain.entity.User;
import org.assignment.domain.model.UserCustomDetails;
import org.assignment.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Phuongnq
 * Implement user details service when load user
 */
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// Load user from database by username
		User user = userRepository.findOne(username);

		// Check user not found
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}

		// Return user custom details with more information
		return new UserCustomDetails(user, getAuthorities(user.getRoles()));
	}

	/**
	 * @param roles - Set roles of user login
	 * @return Collection<GrantedAuthority> authorities granted get from user's roles
	 */
	private Collection<GrantedAuthority> getAuthorities(Set<Role> roles) {

		// Create new Set authorities granted
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

		// Add simple authorities granted
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return grantedAuthorities;
	}
}
