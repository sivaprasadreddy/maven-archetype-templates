package com.sivalabs.quickstartspring;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class UserServiceIT 
{
	@Autowired
	private UserService userService;
	
	@Test
    public void testFindUserById() {
		User user = userService.findUserById(1);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testFindAllusers() {
		List<User> users = userService.findAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.err.println(user);
		}
	}
}
