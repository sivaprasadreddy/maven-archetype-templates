/**
 * 
 */
package com.sivalabs.myapp.web.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sivalabs.myapp.entities.Message;
import com.sivalabs.myapp.entities.User;
import com.sivalabs.myapp.mappers.MessageMapper;
import com.sivalabs.myapp.mappers.UserMapper;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController
{
	@Autowired UserMapper userRepository;
	@Autowired MessageMapper messageRepository;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(@RequestParam(name="page", defaultValue="0") int pageNo, Model model)
	{
		if(pageNo <0) pageNo = 0;
		
		List<Message> result = messageRepository.findAll();
		model.addAttribute("messagesData", result);
		return "home";
	}
	
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public String createMessage(Message msg, Principal principal)
	{
		String email = principal.getName();
		User user = userRepository.findByEmail(email);
		msg.setCreatedBy(user);
		msg.setCreatedOn(new Date());
		//messageRepository.save(msg);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registrationForm(User user, Errors errors)
	{
		if(errors.hasErrors()){
			return "registration";
		}
		User userObj = userRepository.findByEmail(user.getEmail());
		if(userObj != null){
			errors.rejectValue("email", "email.exists","Email already in use");
			return "registration";
		}
		userRepository.save(user);
		return "redirect:/login";
	}
}
