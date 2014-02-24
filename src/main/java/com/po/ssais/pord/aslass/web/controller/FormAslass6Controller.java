/**
 * 
 */
package com.po.ssais.pord.aslass.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.po.ssais.dto.AccountDTO;
import com.po.ssais.pord.aslass.service.FormAslass6Service;

/**
 * @author muraliananthr
 * 
 */
@Controller
@RequestMapping("/formaslass6")
public class FormAslass6Controller {
	private static final Logger LOGGER = Logger
			.getLogger(FormAslass6Controller.class);
	@Autowired
	private FormAslass6Service formAslass6Service;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView loadFormAslass6Page() {
		LOGGER.debug("Inside loadFormAslass6Page() method");
		ModelAndView modelView = new ModelAndView("formaslass6");
		return modelView;
	}

	@RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
	public @ResponseBody
	List<AccountDTO> getAccounts(
			@RequestParam(value = "_search_by_account_no", required = true) String _search_by_account_no,
			@RequestParam(value = "_search_by_account_name", required = true) String _search_by_account_name) {
		LOGGER.debug("Inside getAccounts() method");
		List<AccountDTO> list = formAslass6Service.getAccounts(
				_search_by_account_no, _search_by_account_name);
		return list;
	}

}
