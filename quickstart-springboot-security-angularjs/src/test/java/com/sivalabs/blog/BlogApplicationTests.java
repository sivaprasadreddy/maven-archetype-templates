/**
 * 
 */
package com.sivalabs.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sivalabs.blog.BlogApplication;
import com.sivalabs.blog.entities.Post;
import com.sivalabs.blog.rest.model.PostsRequestDTO;
import com.sivalabs.blog.services.BlogService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlogApplication.class)
@WebAppConfiguration
public class BlogApplicationTests {

	@Autowired
	private BlogService blogService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void test_findPosts() {
		PostsRequestDTO postsRequest = new PostsRequestDTO();
		Page<Post> posts = blogService.findPosts(postsRequest );
		System.out.println(posts);
	}
}
