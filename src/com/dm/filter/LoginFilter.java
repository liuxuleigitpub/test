package com.dm.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.util.SessionKey;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String url = httpRequest.getServletPath();
		// System.out.println("url:"+url);
		if (url.equals("/login.jsp") || url.startsWith("/login") 
				|| url.startsWith("/js")|| url.startsWith("/css")|| url.startsWith("/img")) {
			chain.doFilter(request, response);
		} else {
			if (session.getAttribute(SessionKey.USERID) == null) {
				String path = httpRequest.getContextPath();
				String base_path = httpRequest.getScheme() + "://" + httpRequest.getServerName() + ":"
						+ httpRequest.getServerPort() + path;
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = httpResponse.getWriter();
				out.print("<script language='javascript' type='text/javascript'>");
				out.print("window.location.href='" + base_path + "/login.jsp'");
				out.print("</script>");
			} else
				chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
