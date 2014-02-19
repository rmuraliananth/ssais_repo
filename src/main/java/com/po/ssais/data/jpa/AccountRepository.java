/**
 * 
 */
package com.po.ssais.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.po.ssais.entities.Account;
import com.po.ssais.entities.Customer;

/**
 * @author Murali
 * 
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	public List<Account> findByCustomer(Customer customer);
}
