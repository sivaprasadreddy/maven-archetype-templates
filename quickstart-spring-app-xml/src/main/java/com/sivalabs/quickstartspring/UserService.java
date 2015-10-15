package com.sivalabs.quickstartspring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private UserRepository userRepository;
	
    public User findUserById(Integer userId)
    {
        logger.debug("UserId : {}", userId);
    	return userRepository.findUserById(userId);
    }

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
}
