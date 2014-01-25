package com.po.ssais.login.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.util.StringUtils;

/**
 * @author muraliananthr
 *
 */
public class LogoutManager extends SimpleUrlLogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String cookieName = "SPRING_SECURITY_REMEMBER_ME_COOKIE";
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request
				.getContextPath() : "/");
		response.addCookie(cookie);
		HttpSession session = request.getSession(false);
		if (null == authentication) {
			if (session != null) {
				session.invalidate();
			}
		}
		response.sendRedirect(request.getContextPath());

	}
}
