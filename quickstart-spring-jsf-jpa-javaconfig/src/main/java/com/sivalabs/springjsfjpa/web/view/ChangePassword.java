package com.sivalabs.springjsfjpa.web.view;

import java.io.Serializable;

/**
 * @author Siva
 *
 */
public class ChangePassword implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String currentPwd;
	private String newPwd;
	private String confPwd;
	
	public String getCurrentPwd() {
		return currentPwd;
	}
	public void setCurrentPwd(String currentPwd) {
		this.currentPwd = currentPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfPwd() {
		return confPwd;
	}
	public void setConfPwd(String confPwd) {
		this.confPwd = confPwd;
	}
}
