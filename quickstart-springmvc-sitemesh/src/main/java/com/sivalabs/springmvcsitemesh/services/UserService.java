/**
 * 
 */
package com.sivalabs.springmvcsitemesh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springmvcsitemesh.entities.User;
import com.sivalabs.springmvcsitemesh.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	@Autowired private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
}
