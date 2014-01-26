/**
 * 
 */
package com.po.ssais.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.ssais.entities.User;

/**
 * @author Murali
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {

	public User findOneByUsername(String arg0);
}
