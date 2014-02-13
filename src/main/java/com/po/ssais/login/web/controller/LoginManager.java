package com.po.ssais.login.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.po.ssais.dto.UserDTO;
import com.po.ssais.login.service.LoginService;

/**
 * @author muraliananthr
 * 
 */
public class LoginManager extends SimpleUrlAuthenticationSuccessHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(LoginManager.class);

	/** The user service. */
	@Autowired
	private LoginService loginService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		LOGGER.debug("onAuthenticationSuccess()");

		HttpSession session;
		UserDTO user = null;
		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			session = request.getSession(false);
		} else {
			session = request.getSession();
		}

		if (session == null) {
			sendRedirect(request, response, "/auth/index?sessionexpired=true");
		} else {
			user = loginService.getUser(authentication.getName());
			if (user != null && session != null) {
				session.setAttribute("USER_INFO", user);
				sendRedirect(request, response, "/dashboard/view");
			} else {
				sendRedirect(request, response,
						"/auth/index?sessionexpired=true");
			}

		}

	}

	/**
	 * Method to redirect to the target URL
	 * 
	 * @param request
	 * @param response
	 * @param target
	 * @throws IOException
	 */
	private void sendRedirect(HttpServletRequest request,
			HttpServletResponse response, String target) throws IOException {
		response.sendRedirect(request.getContextPath() + target);
	}

}
