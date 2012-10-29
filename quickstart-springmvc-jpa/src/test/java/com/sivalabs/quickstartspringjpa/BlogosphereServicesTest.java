package com.sivalabs.quickstartspringjpa;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.quickstartspringjpa.entities.Blog;
import com.sivalabs.quickstartspringjpa.entities.Comment;
import com.sivalabs.quickstartspringjpa.entities.Post;
import com.sivalabs.quickstartspringjpa.entities.User;
import com.sivalabs.quickstartspringjpa.services.BlogosphereService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class BlogosphereServicesTest {

	@Autowired
	private BlogosphereService blogosphereService;
	
	@Test
	public void testFindAllUsers() {
		List<User> allUsers = blogosphereService.findAllUsers();
		assertNotNull(allUsers);
		for (User user : allUsers) {
			System.err.println(user);
		}
	}

	@Test
	public void testFindAllBlogs() {
		List<Blog> allBlogs = blogosphereService.findAllBlogs();
		assertNotNull(allBlogs);
		for (Blog blog : allBlogs) {
			System.err.println(blog);
		}
	}

	@Test
	public void testFindAllPosts() {
		List<Post> allPosts = blogosphereService.findAllPosts();
		assertNotNull(allPosts);
		for (Post post : allPosts) {
			System.err.println(post);
		}
	}

	@Test
	public void testFindAllComments() {
		List<Comment> allComments = blogosphereService.findAllComments();
		assertNotNull(allComments);
		for (Comment comment : allComments) {
			System.err.println(comment);
		}
	}

}
