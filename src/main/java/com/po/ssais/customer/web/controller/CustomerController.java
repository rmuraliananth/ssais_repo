package com.po.ssais.customer.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/view")
	public @ResponseBody
	JqGridTableDTO<Object> viewCustomers() {
		JqGridTableDTO e = new JqGridTableDTO();
		e.setPage("1");
		e.setTotal("0");
		e.setRecords("0");
		JqGridRowsDTO<Object> row = new JqGridRowsDTO<Object>();
		List<JqGridRowsDTO<Object>> list = new ArrayList<JqGridRowsDTO<Object>>();
		CustomerDTO o = null;
		for (int i = 0; i < 10; i++) {
			o = new CustomerDTO();
			row.setId(String.valueOf(i));
			o.setId(i);
			row.setCell(o);
			list.add(row);
			// rows.addToCell(o);
		}
		e.setRows(list);
		return e;
	}

}
