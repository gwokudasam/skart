package com.spinhighq.skart.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.dao.UserDAO;
import com.spinhighq.skart.model.Role;

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		com.spinhighq.skart.model.User domainUser = userDAO.getUser(login);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(domainUser.getLogin(), domainUser.getPassword(),
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(domainUser.getRoles()));
	}

	public Collection<SimpleGrantedAuthority> getAuthorities(Set<Role> roles) {
		List<SimpleGrantedAuthority> authList = getGrantedAuthorities(roles);
		return authList;
	}

	
	public static List<SimpleGrantedAuthority> getGrantedAuthorities(
			Set<Role> roles) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

}