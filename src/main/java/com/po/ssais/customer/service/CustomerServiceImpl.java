/**
 * 
 */
package com.po.ssais.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.po.ssais.data.jpa.AccountRepository;
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
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<CustomerDTO> fetchCustomers(final JqGridSearchDTO searchDTO) {
		LOGGER.debug("Fetch Customers");
		// TODO :: apply filter condition
		int page = (searchDTO.getPage() == 0 ? 0 : searchDTO.getPage() - 1);
		final PageRequest pageRequest = new PageRequest(page,
				searchDTO.getRows());
		Page<Customer> cu = customerRepository.findAll(pageRequest);
		searchDTO.setTotal(cu.getTotalElements());
		List<Customer> customerEntities = cu.getContent();
		return convertToDTOs(customerEntities);
	}

	@Override
	public void addCustomer(CustomerDTO customerDTO) {
		LOGGER.debug("Add Customer");
		Customer entity = convertCustomerDtoToEntity(customerDTO);
		entity.setCrtTsp(new Date());
		entity.setUptTsp(new Date());

		Customer savedCustomer = customerRepository.saveAndFlush(entity);

		Account account = convertAccountDtoToEntity(customerDTO);
		if (account != null) {
			account.setCustomer(savedCustomer);
			account.setCrtTsp(entity.getCrtTsp());
			account.setUptTsp(entity.getUptTsp());
			// Set<Account> accounts = new LinkedHashSet<Account>();
			// accounts.add(account);
			accountRepository.save(account);

		}

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
		Customer entity = convertCustomerDtoToEntity(customerDTO);
		entity.setUptTsp(new Date());
		customerRepository.saveAndFlush(entity);

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

	private CustomerDTO convertEntityToDTO(Customer entity) {
		LOGGER.debug("Convert customer entity to dto");
		CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmailId(entity.getEmailId());
		dto.setPhoneNo(entity.getPhoneNo());
		dto.setAddress(entity.getAddress());
		dto.setCrtTsp(entity.getCrtTsp());
		dto.setUptTsp(entity.getUptTsp());

		if (entity.getAccounts() != null && !entity.getAccounts().isEmpty()) {
			Iterator<Account> element = entity.getAccounts().iterator();
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
		Customer entity = new Customer();
		entity.setId(customerDTO.getId());
		entity.setName(customerDTO.getName());
		entity.setEmailId(customerDTO.getEmailId());
		entity.setPhoneNo(customerDTO.getPhoneNo());
		entity.setAddress(customerDTO.getAddress());
		entity.setCrtTsp(customerDTO.getCrtTsp());
		entity.setUptTsp(customerDTO.getUptTsp());

		return entity;
	}

	private Account convertAccountDtoToEntity(CustomerDTO customerDTO) {

		Account account = null;
		if (customerDTO.getAccount() != null) {
			account = new Account();
			account.setAccountNo(customerDTO.getAccount().getAccountNo());
			account.setName(customerDTO.getName());
			account.setOpenDate(customerDTO.getAccount().getOpenDate());
			account.setMaturityDate(customerDTO.getAccount().getMaturityDate());
			account.setPrincipalAmount(new BigDecimal(customerDTO.getAccount()
					.getPrincipalAmount()));
			// TODO ::
			account.setBalanceAmount(new BigDecimal(customerDTO.getAccount()
					.getPrincipalAmount()));
			account.setRateOfInterest(new BigDecimal(9.75d));
			account.setAccountType("NEW");
			account.setLastPaidDate(new Date());
			account.setCrtTsp(customerDTO.getCrtTsp());
			account.setUptTsp(customerDTO.getUptTsp());
		}

		return account;
	}

}
