package com.po.ssais.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author muraliananthr
 * 
 */
public class SSAAuthenticationManager extends DaoAuthenticationProvider
		implements AuthenticationManager, UserDetailsService {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		System.out.println("authenticate()");
//		return super.authenticate(authentication);
		return new UsernamePasswordAuthenticationToken(authentication.getName(),
				authentication.getCredentials());
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		System.out.println("loadUserByUsername()");
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
//		authList.add(new SimpleGrantedAuthority("RememberMeAuthenticatedUser"));
		return new User("admin", "admin",authList);
	}

}
