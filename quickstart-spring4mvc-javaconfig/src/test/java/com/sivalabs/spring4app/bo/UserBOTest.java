/**
 * 
 */
package com.sivalabs.spring4app.bo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.spring4app.config.AppConfig;
import com.sivalabs.spring4app.domain.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserBOTest 
{
	@Autowired
	private UserBO userBO;
	
	@Test
	public void findAllUsers()  {
		List<User> users = userBO.findAllUsers();
		System.err.println(users);
	}
}
