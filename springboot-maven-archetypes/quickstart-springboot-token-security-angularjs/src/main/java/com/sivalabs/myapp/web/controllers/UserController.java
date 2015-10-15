/**
 * 
 */
package com.sivalabs.myapp.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.myapp.entities.User;
import com.sivalabs.myapp.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@RestController
public class UserController 
{
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value="/api/users", method=RequestMethod.GET)
	public List<User> list() 
	{
		return repo.findAll();
	}
}
