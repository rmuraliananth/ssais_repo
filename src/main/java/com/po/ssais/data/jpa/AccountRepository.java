/**
 * 
 */
package com.po.ssais.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	public List<Account> findByAccountNoLikeOrNameLikeOrderByAccountNoDesc(
			String accountNo, String name);

	@Query("from Account a where accountNo like %:accountNo% or customer.name like %:name% order by accountNo desc")
	public List<Account> searchByAccountNoLikeOrNameLikeOrderByAccNoDesc(
			@Param("accountNo") String accountNo, @Param("name") String name);

}
