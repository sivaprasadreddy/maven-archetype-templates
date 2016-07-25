/**
 * 
 */
package com.sivalabs.blog.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class AuthenticatedUser {

	private String email;
	private List<String> roles = new ArrayList<String>();
	
	public AuthenticatedUser(String email, List<String> roles) {
		this.email = email;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public List<String> getRoles() {
		return roles;
	}

}
