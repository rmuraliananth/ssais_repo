/**
 * 
 */
package com.po.ssais.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.ssais.data.jpa.UserRepository;
import com.po.ssais.dto.UserDTO;

/**
 * @author muraliananthr
 * 
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO getUser(final String userName) {
		com.po.ssais.entities.User user = userRepository
				.findOneByUsername(userName);
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setName(user.getName());
		return dto;
	}

}
