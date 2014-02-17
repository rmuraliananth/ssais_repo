/**
 * 
 */
package com.po.ssais.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.ssais.entities.Account;

/**
 * @author Murali
 *
 */
public interface AccountRepository extends  JpaRepository<Account, Long> {

}
