package com.po.ssais.customer.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadCustomerPage() {
		LOGGER.debug("Inside loadCustomerPage() method");
		ModelAndView modelView = new ModelAndView("customer");
		return modelView;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public @ResponseBody
	void addTrain(@RequestBody CustomerDTO customer) {
	}

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<Object> viewCustomers() {
		JqGridTableDTO table = new JqGridTableDTO();
		List<CustomerDTO> rowList = new ArrayList<CustomerDTO>();
		JqGridRowsDTO<Object> row = null;
		Object[] cell = null;

		table.setPage("1");
		table.setTotal("10");
		table.setRecords("10");

		for (int i = 0; i < 10; i++) {
			CustomerDTO o = new CustomerDTO();
			o.setId(i);
			o.setName("Customer-" + i);
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(10 + i);
			accountDTO.setAccountNo("123-" + i);
			o.setAccount(accountDTO);
			cell = new Object[10];
			cell[0] = o.getId();
			cell[1] = o.getName();

			row = new JqGridRowsDTO<Object>();
			row.setId(String.valueOf(i));
			row.setCell(cell);
			// rowList.add(row);
			rowList.add(o);
		}
		table.setRows(rowList);
		return table;
	}

}
