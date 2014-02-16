package com.po.ssais.customer.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.po.ssais.customer.service.CustomerService;
import com.po.ssais.dto.CustomerDTO;
import com.po.ssais.dto.jqgrid.JqGridSearchDTO;
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

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public @ResponseBody
	void updateCustomer(@RequestBody CustomerDTO customer) {
		LOGGER.info("Update Customer Details...");
		customerService.updateCustomer(customer);
	}

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<Object> viewCustomers(
			@RequestParam(value = "_search", required = false) boolean _search,
			@RequestParam(value = "page", required = false) int page,
			@RequestParam(value = "rows", required = false) int rows,
			@RequestParam(value = "searchField", required = false) String searchField,
			@RequestParam(value = "searchOper", required = false) String searchOper,
			@RequestParam(value = "searchString", required = false) String searchString,
			@RequestParam(value = "sord", required = false) String sord) {

		LOGGER.info("Fetch Customer Details...");
		JqGridSearchDTO searchDTO = new JqGridSearchDTO(_search, page, rows,
				searchField, searchOper, searchString, sord);
		List<CustomerDTO> rowList = customerService.fetchCustomers(searchDTO);

		JqGridTableDTO table = new JqGridTableDTO();
		double totalPages = 0;
		double pages = page;
		double limit = rows;
		if (searchDTO.getTotal() > 0) {
			totalPages = Math.ceil(searchDTO.getTotal() / limit);
		}

		if (pages > totalPages) {
			pages = totalPages;
		}
		table.setPage(String.valueOf(pages));
		table.setTotal(String.valueOf(totalPages));
		table.setRecords(String.valueOf(searchDTO.getTotal()));
		table.setRows(rowList);
		table.setUserdata(rowList);
		return table;
	}

}
