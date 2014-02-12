/**
 * 
 */
package com.po.ssais.login.service;

import com.po.ssais.dto.UserDTO;

/**
 * @author muraliananthr
 * 
 */
public interface LoginService {	
	public UserDTO getUser(final String name);
}
