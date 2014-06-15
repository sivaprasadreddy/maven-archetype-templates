/**
 * 
 */
package com.sivalabs.myapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="USERS")
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true, nullable=false)
	private String userName;
	@Column(nullable=false)
	private String password;
	@Column(unique=true, nullable=false)
	private String email;
	
	public User()
	{
	}
	
	public User(Integer id)
	{
		this.id = id;
	}
	
	public User(Integer id, String userName, String password, String email)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
