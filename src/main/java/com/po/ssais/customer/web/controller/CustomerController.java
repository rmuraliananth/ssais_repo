package com.po.ssais.customer.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.po.ssais.customer.service.CustomerService;
import com.po.ssais.dto.AccountDTO;
import com.po.ssais.dto.CustomerDTO;
import com.po.ssais.dto.jqgrid.JqGridRowsDTO;
import com.po.ssais.dto.jqgrid.JqGridTableDTO;

/**
 * @author Murali
 * 
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger LOGGER = Logger
			.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadCustomerPage() {
		LOGGER.debug("Inside loadCustomerPage() method");
		ModelAndView modelView = new ModelAndView("customer");
		return modelView;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public @ResponseBody
	void addCustomer(@RequestBody CustomerDTO customer) {
		LOGGER.info("Add New Customer Details...");
		customerService.addCustomer(customer);
	}

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<Object> viewCustomers() {
		LOGGER.info("Fetch Customer Details...");
		JqGridTableDTO table = new JqGridTableDTO();
		List<CustomerDTO> rowList = customerService.fetchCustomers();
		int noOfRecords = rowList.size();
		int totalPages = 0;
		int pages = 1;
		if (noOfRecords > 0) {
			totalPages = noOfRecords / 10;
		}

		if (pages > totalPages) {
			pages = totalPages;
		}
		table.setPage(String.valueOf(pages));
		table.setTotal(String.valueOf(totalPages));
		table.setRecords(String.valueOf(rowList.size()));
		table.setRows(rowList);
		return table;
	}

}
