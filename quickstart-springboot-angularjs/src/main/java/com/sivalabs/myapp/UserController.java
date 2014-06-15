/**
 * 
 */
package com.sivalabs.myapp;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author katsi02
 *
 */
@RestController
@RequestMapping(value="/users/", produces=APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired private UserRepository userRepository;

	@RequestMapping(value="", method=GET)
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
