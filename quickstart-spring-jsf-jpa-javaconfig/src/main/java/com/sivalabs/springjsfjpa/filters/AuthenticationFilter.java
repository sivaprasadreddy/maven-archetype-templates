package com.sivalabs.springjsfjpa.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sivalabs.springjsfjpa.entities.User;

/**
 * @author Siva
 *
 */
public class AuthenticationFilter implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		String requestPath = requestURI.substring(contextPath.length()+1);
		User loggedinUser = (User) httpRequest.getSession().getAttribute("LOGIN_USER");
		
		if (!isPublicUrl(requestPath) && loggedinUser == null)
		{
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/views/login.jsf");
		} 
		else 
		{
			chain.doFilter(request, response);
		}
		
	}
	
	private boolean isPublicUrl(String url){
		return 	url.startsWith("views/login.jsf") 
				|| url.startsWith("views/registration.jsf") 
				|| url.startsWith("javax.faces.resource");
	}
	
	@Override
	public void destroy()
	{
	}

}
