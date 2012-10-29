/**
 * 
 */
package com.sivalabs.springmvcsitemesh.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.springmvcsitemesh.entities.User;
import com.sivalabs.springmvcsitemesh.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		return "welcome";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping("/userhome")
	public String userhome(Model model) 
	{
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "userhome";
	}
	
	@RequestMapping("/admin/adminhome")
	public String adminhome(Model model) 
	{
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "admin/adminhome";
	}
}
