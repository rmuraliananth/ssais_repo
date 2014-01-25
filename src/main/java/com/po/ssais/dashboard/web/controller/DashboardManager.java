package com.po.ssais.dashboard.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.po.ssais.login.service.LoginService;

/**
 * @author muraliananthr
 * 
 */

public class DashboardManager extends SimpleUrlAuthenticationSuccessHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(DashboardManager.class);
	
	/** The user service. */
	@Autowired
	private LoginService loginService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

//		if (null != loginService) {
//			HttpSession session;
//			LoginDTO user = null;
//			String timeZone = request.getParameter("timeZoneVal");
//			LOGGER.info("Time Zone:" + timeZone);
//			if (authentication instanceof UsernamePasswordAuthenticationToken) {
//				session = request.getSession(false);
//			} else {
//				session = request.getSession();
//			}
//
//			if (session == null) {
//				sendRedirect(request, response,
//						"/telepathdata/expire.html?expire=true");
//			} else {
//
//				try {
//					user = loginService
//							.getUserDetails(authentication.getName());
//					if (user != null && session != null) {
//						session.setAttribute(TPDCommonConstants.USER_ID,
//								user.getUserId());
//						session.setAttribute(TPDCommonConstants.USER_NAME,
//								user.getUserName());
//						session.setAttribute(TPDCommonConstants.USER_EMAIL,
//								user.getEmailId());
//						session.setAttribute(TPDCommonConstants.TIME_ZONE,
//								timeZone);
//						session.setAttribute(TPDCommonConstants.DESKTOP,
//								Boolean.valueOf(desktop));
//						session.setAttribute(TPDCommonConstants.LOGIN_SUCCESS,
//								TPDCommonConstants.LOGIN_SUCCESS);
//						validateMasterEntries();
//					}
//				} catch (TelepathServiceException e) {
//					LOGGER.debug("Error while fetching the data with the given email id:"
//							+ authentication.getName());
//				}
//
//				// Check for user validity
//				if (user == null || user.getCheckValidity()) {
//
//					if (session != null) {
//						session.invalidate();
//					}
//
//					sendRedirect(request, response,
//							"/telepathdata/expire.html?expire=true");
//
//				}
//
//				else {
//
//					int userId = (Integer) session
//							.getAttribute(TPDCommonConstants.USER_ID);
//					List<DatasourceDTO> datasourceDTOs = new ArrayList<DatasourceDTO>();
//					try {
//						datasourceDTOs = datasourceService
//								.getDataSourceDetails(userId, Boolean.TRUE);
//
//					} catch (TelepathServiceException e) {
//						LOGGER.debug("Error while fetching the datasource for the given user id: "
//								+ userId);
//					}
//					if (datasourceDTOs != null && !datasourceDTOs.isEmpty()) {
//						sendRedirect(request, response,
//								"/telepathdata/visualization.html");
//					} else {
//						sendRedirect(request, response,
//								"/dataSource/displayDataSource.html");
//					}
//				}
//			}
//		}

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
