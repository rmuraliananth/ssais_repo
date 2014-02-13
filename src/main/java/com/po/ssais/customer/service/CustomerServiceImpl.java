/**
 * 
 */
package com.po.ssais.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.ssais.data.jpa.CustomerRepository;
import com.po.ssais.dto.CustomerDTO;
import com.po.ssais.entities.Customer;

/**
 * @author muraliananthr
 * 
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerDTO> fetchCustomers() {
		List<Customer> customerEntities = customerRepository.findAll();
		return convertToDTOs(customerEntities);
	}

	@Override
	public void addCustomer(CustomerDTO customerDTO) {
		Customer entity = convertToEntity(customerDTO);
		customerRepository.saveAndFlush(entity);
	}

	@Override
	public void updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub

	}

	private List<CustomerDTO> convertToDTOs(
			final List<Customer> customerEntities) {
		List<CustomerDTO> listCustomer = new ArrayList<CustomerDTO>();
		for (Customer customerEntity : customerEntities) {
			CustomerDTO e = convertToDTO(customerEntity);
			listCustomer.add(e);
		}
		return listCustomer;
	}

	private CustomerDTO convertToDTO(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	private Customer convertToEntity(CustomerDTO customerDTO) {
		Customer entity = new Customer();
		entity.setName(customerDTO.getName());
		entity.setCrtTsp(new Date());
		return entity;
	}

}
