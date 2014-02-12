package com.po.ssais.login.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.po.ssais.login.service.LoginService;

/**
 * @author muraliananthr
 * 
 */
@Controller
@RequestMapping("/auth")
public class LoginFormController {

	private static final Logger LOGGER = Logger
			.getLogger(LoginFormController.class);

	@Autowired
	LoginService loginService;

	/** The login err msg. */
	@Value("${login.err.msg}")
	private String loginErrMsg;

	/** The login err msg. */
	@Value("${login.err.sessionexpired}")
	private String loginSessionExpired;

	/** The login error. */
	@Value("${login.error}")
	private String loginError;

	/**
	 * This method is used to handle login mechanism.
	 * 
	 * @param LoginForm
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm,
			@RequestParam(value = "error", required = false) boolean error,
			HttpSession session) {

		LOGGER.debug("Inside login method");

		ModelAndView modelView = new ModelAndView();
		try {
			if (error) {
				modelView.addObject("loginForm", new LoginForm());
				modelView.addObject("errorMessage", loginErrMsg);
				modelView.setViewName("login");
			}

		} catch (Exception exception) {
			LOGGER.error("An error occurred while saving login details. ",
					exception);
			modelView.setViewName("login");
			modelView.addObject("errorMessage", loginError);
			return modelView;
		}
		modelView.addObject("userName", loginForm.getUsername());
		modelView.setViewName("visualization");
		return modelView;
	}

	/**
	 * This method shows login screen as default index page.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage(
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "sessionexpired", required = false) boolean sessionexpired,
			HttpSession session) {
		LOGGER.debug("Inside indexPage method");

		ModelAndView modelView = new ModelAndView();

		if (error) {
			modelView.addObject("errorMessage", loginErrMsg);
		}

		if (sessionexpired) {
			modelView.addObject("errorMessage", loginSessionExpired);
		}

		modelView.addObject("loginForm", new LoginForm());
		modelView.setViewName("login");
		return modelView;
	}

}
