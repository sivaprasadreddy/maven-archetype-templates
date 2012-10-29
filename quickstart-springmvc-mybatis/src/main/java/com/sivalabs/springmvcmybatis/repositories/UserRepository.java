/**
 * 
 */
package com.sivalabs.springmvcmybatis.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sivalabs.springmvcmybatis.entities.User;
import com.sivalabs.springmvcmybatis.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private UserMapper userMapper;
	
	public User findUserById(Integer userId) {
		return userMapper.findUserById(userId);
	}

	public List<User> findAllUsers() {
		return userMapper.findAllUsers(); 
	}
}
