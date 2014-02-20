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
@RequestMapping("/dashboard")
public class DashboardController {
	private static final Logger LOGGER = Logger
			.getLogger(DashboardController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView viewHomePage() {
		LOGGER.debug("View home page...");
		ModelAndView modelView = new ModelAndView("home");
		return modelView;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewDashboardPage() {
		LOGGER.debug("View dashboard page...");
		ModelAndView modelView = new ModelAndView("dashboard");
		return modelView;
	}

}
