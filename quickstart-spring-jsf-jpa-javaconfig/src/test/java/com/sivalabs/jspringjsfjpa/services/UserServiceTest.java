/**
*
*
*/
package com.sivalabs.jspringjsfjpa.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.springjsfjpa.config.AppConfig;
import com.sivalabs.springjsfjpa.entities.User;
import com.sivalabs.springjsfjpa.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class UserServiceTest {

	@Autowired UserService userService;
	
	@Test
	public void login() {
		User user = this.userService.login("admin@gmail.com", "admin");
		Assert. assertNotNull(user);
	}
}
