package com.sivalabs.myapp;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@SessionScoped
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	UserServiceBean userServiceBean;
	
	private User loginUser;
	
	private String email;
	private String password;
	
    public String login()
    {
    	logger.debug("email :{}, Password: {}", email, password);
    	String view="login";
    	
    	User user = userServiceBean.login(email, password);
    	if(user != null){
    		loginUser = user;
    		view = "welcome.jsf?faces-redirect=true";
    	} else {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid UserName and Password", null));
    	}
    	return view;
    }

    public String logout()
    {
    	((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
    	return "login.jsf?faces-redirect=true";
    }
    
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public User getLoginUser()
	{
		return loginUser;
	}
	
}
