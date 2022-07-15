package org.com.panorama.service.impl;

import org.com.panorama.model.CustomUserDetails;
import org.com.panorama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userService.loadByUsername(username);
	}

}
