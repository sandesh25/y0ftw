package com.system.aop;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UtilityThreadLocal {
	private static final ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
	private static ServletContext servletContext;

	public static void initialize(HttpServletRequest request, HttpServletResponse response) {
		UtilityThreadLocal.request.set(request);
		UtilityThreadLocal.response.set(response);
	}

	public static HttpServletRequest getRequest() {
		return request.get();
	}

	public static boolean isSessionValidated() {
		return request.get().getAttribute("sessionValidated") != null;
	}

	public static void setSessionValidated() {
		if (request.get() != null) {
			request.get().setAttribute("sessionValidated", true);
		}
	}

	public static HttpServletResponse getResponse() {
		return response.get();
	}

	public static String getUserId() {
		return getSession().getId();
	}

	public static String getUserName() {
		return getSession().getId();
	}

	public static HttpSession getSession() {
		return request.get().getSession();
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setServletContext(ServletContext servletContext) {
		UtilityThreadLocal.servletContext = servletContext;
	}

	public static void clear() {
		request.remove();
		response.remove();
		// session.remove();
	}

	public static String getUserToken() {
		return request.get().getSession().getId();
	}
}
