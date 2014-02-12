package com.po.ssais.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.po.ssais.data.jpa.UserRepository;

/**
 * @author muraliananthr
 * 
 */
public class SSAAuthenticationManager extends DaoAuthenticationProvider
		implements AuthenticationManager, UserDetailsService {
	private static final Logger LOGGER = Logger
			.getLogger(SSAAuthenticationManager.class);

	@Autowired
	private UserRepository userRepository;

	/** The user not exist. */
	@Value("${login.err.user.notexist}")
	private String userNotExist;
	@Value("${login.err.wrong.password}")
	private String wrongPassword;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		LOGGER.debug("authenticate()");

		com.po.ssais.entities.User user = userRepository
				.findOneByUsername(authentication.getPrincipal().toString());
		if (user == null) {
			throw new BadCredentialsException(userNotExist);
		}

		if (user != null
				&& !user.getPassword().equals(authentication.getCredentials())) {
			throw new BadCredentialsException(wrongPassword);
		}

		return new UsernamePasswordAuthenticationToken(
				authentication.getName(), authentication.getCredentials());
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		LOGGER.debug("Load user by username.");
		com.po.ssais.entities.User user = userRepository
				.findOneByUsername(arg0);
		if (user == null) {
			throw new UsernameNotFoundException(userNotExist);
		}
		List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("RememberMeAuthenticatedUser"));
		return new User(user.getUsername(), user.getPassword(), authList);
	}

}
