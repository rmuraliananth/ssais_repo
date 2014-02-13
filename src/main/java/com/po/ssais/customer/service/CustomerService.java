/**
 * 
 */
package com.po.ssais.customer.service;

import java.util.List;

import com.po.ssais.dto.CustomerDTO;

/**
 * @author muraliananthr
 * 
 */
public interface CustomerService {

	public List<CustomerDTO> fetchCustomers();

	public void addCustomer(CustomerDTO customerDTO);

	public void updateCustomer(CustomerDTO customerDTO);

	public void deleteCustomer(CustomerDTO customerDTO);
}
