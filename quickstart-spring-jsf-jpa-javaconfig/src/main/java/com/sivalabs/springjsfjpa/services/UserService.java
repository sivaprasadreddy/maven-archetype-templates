package com.sivalabs.springjsfjpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springjsfjpa.entities.User;
import com.sivalabs.springjsfjpa.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	
	@Autowired private UserRepository userRepository;

  
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	
	
}
