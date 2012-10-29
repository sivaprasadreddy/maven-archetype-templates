/**
 * 
 */
package com.sivalabs.quickstartspringjpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivalabs.quickstartspringjpa.entities.Blog;
import com.sivalabs.quickstartspringjpa.services.BlogosphereService;

/**
 * @author Siva
 *
 */
@Controller
public class BlogController {

	@Autowired
	private BlogosphereService blogosphereService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		List<Blog> blogs = blogosphereService.findAllBlogs();
		model.addAttribute("BLOGS", blogs);
		return "welcome";
	}
}
