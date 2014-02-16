/**
 * 
 */
package com.po.ssais.customer.service;

import java.util.List;

import com.po.ssais.dto.CustomerDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;

/**
 * @author muraliananthr
 * 
 */
public interface CustomerService {

	public List<CustomerDTO> fetchCustomers(final JqGridSearchDTO searchDTO);

	public void addCustomer(CustomerDTO customerDTO);

	public void updateCustomer(CustomerDTO customerDTO);

	public void deleteCustomer(CustomerDTO customerDTO);
}
