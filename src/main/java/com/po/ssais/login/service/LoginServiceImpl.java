/**
 * 
 */
package com.po.ssais.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.ssais.data.jpa.UserRepository;
import com.po.ssais.dto.UserDTO;
import com.po.ssais.entities.User;

/**
 * @author muraliananthr
 * 
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	private static final Logger LOGGER = Logger
			.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO getUser(final String userName) {
		LOGGER.debug("Get user instance by user name");
		User user = userRepository.findOneByUsername(userName);
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setName(user.getName());
		return dto;
	}

}
