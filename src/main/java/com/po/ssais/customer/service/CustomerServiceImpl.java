/**
 * 
 */
package com.po.ssais.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.ssais.data.jpa.CustomerRepository;
import com.po.ssais.dto.AccountDTO;
import com.po.ssais.dto.CustomerDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
import com.po.ssais.entities.Account;
import com.po.ssais.entities.Customer;

/**
 * @author muraliananthr
 * 
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = Logger
			.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDTO> fetchCustomers(final JqGridSearchDTO searchDTO) {
		LOGGER.debug("Fetch Customers");
		// TODO :: apply filter condition
		int page = (searchDTO.getPage() == 0 ? 0 : searchDTO.getPage() - 1);
		final PageRequest pageRequest = new PageRequest(page,
				searchDTO.getRows());
		Page<Customer> results = customerRepository.findAll(pageRequest);
		searchDTO.setTotal(results.getTotalElements());
		List<Customer> customers = results.getContent();
		return convertToDTOs(customers);
	}

	@Override
	public void addCustomer(CustomerDTO customerDTO) {
		LOGGER.debug("Add Customer");
		Customer customer = convertCustomerDtoToEntity(customerDTO);
		customer.setCrtTsp(new Date());
		customer.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(customerDTO);
		if (account != null) {
			account.setCustomer(customer);
			account.setCrtTsp(customer.getCrtTsp());
			account.setUptTsp(customer.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
			customer.setAccounts(accounts);
		}

		Customer savedCustomer = customerRepository.save(customer);

		// if (entity.getAccounts() != null & !entity.getAccounts().isEmpty()) {
		// Iterator<Account> element = entity.getAccounts().iterator();
		// while (element.hasNext()) {
		// Account account = element.next();
		// account.setCustomer(savedCustomer);
		// account.setCrtTsp(entity.getCrtTsp());
		// account.setUptTsp(entity.getUptTsp());
		// }
		// }

	}

	@Override
	public void updateCustomer(CustomerDTO customerDTO) {
		LOGGER.debug("Update Customer");
		Customer customer = convertCustomerDtoToEntity(customerDTO);
		customer.setUptTsp(new Date());

		Account account = convertAccountDtoToEntity(customerDTO);
		if (account != null) {
			account.setCustomer(customer);
			account.setUptTsp(customer.getUptTsp());
			Set<Account> accounts = new HashSet<Account>();
			accounts.add(account);
			customer.setAccounts(accounts);
		}
		customerRepository.save(customer);

	}

	@Override
	public void deleteCustomer(CustomerDTO customerDTO) {
		LOGGER.debug("Delete Customer");
		Customer entity = convertCustomerDtoToEntity(customerDTO);
		customerRepository.delete(entity);
	}

	private List<CustomerDTO> convertToDTOs(
			final List<Customer> customerEntities) {
		LOGGER.debug("Convert customer entity to dto");
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		for (Customer customerEntity : customerEntities) {
			CustomerDTO e = convertEntityToDTO(customerEntity);
			customerList.add(e);
		}
		return customerList;
	}

	private CustomerDTO convertEntityToDTO(Customer customer) {
		LOGGER.debug("Convert customer entity to dto");
		CustomerDTO dto = new CustomerDTO();
		dto.setId(customer.getId());
		dto.setName(customer.getName());
		dto.setEmailId(customer.getEmailId());
		dto.setPhoneNo(customer.getPhoneNo());
		dto.setAddress(customer.getAddress());
		dto.setCrtTsp(customer.getCrtTsp());
		dto.setUptTsp(customer.getUptTsp());

		// List<Account> accounts = accountRepository.findByCustomer(customer);
		// for (Account account : accounts) {
		// AccountDTO accountDTO = new AccountDTO();
		// accountDTO.setId(account.getId());
		// accountDTO.setAccountNo(account.getAccountNo());
		// accountDTO.setOpenDate(account.getOpenDate());
		// accountDTO.setMaturityDate(account.getMaturityDate());
		// if (account.getPrincipalAmount() != null) {
		// accountDTO.setPrincipalAmount(account.getPrincipalAmount()
		// .doubleValue());
		// }
		// dto.setAccount(accountDTO);
		// }

		if (customer.getAccounts() != null && !customer.getAccounts().isEmpty()) {
			Iterator<Account> element = customer.getAccounts().iterator();
			while (element.hasNext()) {
				Account account = element.next();
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(account.getId());
				accountDTO.setAccountNo(account.getAccountNo());
				accountDTO.setOpenDate(account.getOpenDate());
				accountDTO.setMaturityDate(account.getMaturityDate());
				if (account.getPrincipalAmount() != null) {
					accountDTO.setPrincipalAmount(account.getPrincipalAmount()
							.doubleValue());
				}
				dto.setAccount(accountDTO);
			}

		}
		return dto;
	}

	private Customer convertCustomerDtoToEntity(CustomerDTO customerDTO) {
		LOGGER.debug("Convert customer dto to entity");
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setName(customerDTO.getName());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setPhoneNo(customerDTO.getPhoneNo());
		customer.setAddress(customerDTO.getAddress());
		customer.setCrtTsp(customerDTO.getCrtTsp());
		customer.setUptTsp(customerDTO.getUptTsp());

		return customer;
	}

	private Account convertAccountDtoToEntity(CustomerDTO customerDTO) {

		Account account = null;
		if (customerDTO.getAccount() != null) {
			account = new Account();
			account.setId(customerDTO.getAccount().getId());
			account.setAccountNo(customerDTO.getAccount().getAccountNo());
			account.setName(customerDTO.getName());
			account.setOpenDate(customerDTO.getAccount().getOpenDate());
			account.setMaturityDate(customerDTO.getAccount().getMaturityDate());
			account.setPrincipalAmount(new BigDecimal(customerDTO.getAccount()
					.getPrincipalAmount()));

			// TODO :: implement balance amount check , last paid date & ROI

			account.setBalanceAmount(account.getPrincipalAmount());
			account.setLastPaidDate(customerDTO.getAccount().getOpenDate());

			account.setRateOfInterest(new BigDecimal(9.75d));
			account.setAccountType("NEW");

			account.setCrtTsp(customerDTO.getCrtTsp());
			account.setUptTsp(customerDTO.getUptTsp());
		}

		return account;
	}

}
