/**
 * 
 */
package com.sivalabs.springjsfjpa.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sivalabs.springjsfjpa.config.SpringApplicationContext;
import com.sivalabs.springjsfjpa.entities.User;
import com.sivalabs.springjsfjpa.services.UserService;
import com.sivalabs.springjsfjpa.utils.JSFUtils;
import com.sivalabs.springjsfjpa.web.view.ChangePassword;

/**
 * @author Siva
 *
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	private UserService userService;
	
	private User loginUser;
	private boolean userLoggedin;
	private ChangePassword changePwd = new ChangePassword();
	
	public UserController() {
		loginUser = new User();
		loginUser.setEmail("admin@gmail.com");
		loginUser.setPassword("admin");
	}
	
	public UserService getUserService() {
        if(userService == null){
            this.userService = SpringApplicationContext.getBean(UserService.class);
        }
	    return userService;
    }
	
	public String doLogin() 
	{
		User user = getUserService().login(loginUser.getEmail(), loginUser.getPassword());
		if(user != null)
		{
			JSFUtils.setLoggedinUser(user);
			loginUser = user;
			setUserLoggedin(true);
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid EmailId and Password");
		return null;
	}
	
	
	public String logout()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.invalidate();
		return "login.jsf?faces-redirect=true";
	}
	
	
	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public boolean isUserLoggedin()
	{
		return userLoggedin;
	}
	public void setUserLoggedin(boolean userLoggedin)
	{
		this.userLoggedin = userLoggedin;
	}
	public ChangePassword getChangePwd() {
		return changePwd;
	}

	public void setChangePwd(ChangePassword changePwd) {
		this.changePwd = changePwd;
	}

	
}
