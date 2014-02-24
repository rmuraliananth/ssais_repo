package com.po.ssais.customer.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.po.ssais.AbstractContextTests;
import com.po.ssais.data.jpa.AccountRepository;
import com.po.ssais.entities.Account;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest extends AbstractContextTests {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void testFetchAccount() {
		List<Account> list = accountRepository
				.findByAccountNoLikeOrNameLikeOrderByAccountNoDesc("4", "t");
		System.out.println(list);

	}

	// public void testFetchCustomers() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testFetchCustomers() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testAddCustomer() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testUpdateCustomer() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteCustomer() {
	// fail("Not yet implemented");
	// }

}
