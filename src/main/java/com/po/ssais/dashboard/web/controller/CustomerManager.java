package com.po.ssais.dashboard.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author muraliananthr
 * 
 */
@Controller
@RequestMapping("/customer")
public class CustomerManager {
	private static final Logger LOGGER = Logger
			.getLogger(CustomerManager.class);

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getCustomer() {
		LOGGER.debug("Inside getCustomer() method");
		ModelAndView modelView = new ModelAndView("dashboard");
		return modelView;
	}

}
