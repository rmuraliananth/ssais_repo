/**
 * 
 */
package com.po.ssais.pord.aslass.web.controller;

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
@RequestMapping("/formaslass6")
public class FormAslass6Controller {
	private static final Logger LOGGER = Logger
			.getLogger(FormAslass6Controller.class);
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadFormAslass6Page() {
		LOGGER.debug("Inside loadFormAslass6Page() method");
		ModelAndView modelView = new ModelAndView("formaslass6");
		return modelView;
	}

}
