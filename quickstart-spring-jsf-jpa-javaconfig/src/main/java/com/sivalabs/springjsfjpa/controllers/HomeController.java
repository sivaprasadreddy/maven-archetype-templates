package com.sivalabs.springjsfjpa.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * @author Siva
 *
 */
@ManagedBean
@ViewScoped
public class HomeController implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	
	public HomeController()
	{
	}
	
	@PostConstruct
	void init()
	{
		
	}
	
}
