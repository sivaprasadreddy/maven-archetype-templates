/**
 * 
 */
package com.sivalabs.quickstartspringjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.quickstartspringjpa.entities.Blog;
import com.sivalabs.quickstartspringjpa.entities.Comment;
import com.sivalabs.quickstartspringjpa.entities.Post;
import com.sivalabs.quickstartspringjpa.entities.User;
import com.sivalabs.quickstartspringjpa.repositories.BlogRepository;
import com.sivalabs.quickstartspringjpa.repositories.CommentRepository;
import com.sivalabs.quickstartspringjpa.repositories.PostRepository;
import com.sivalabs.quickstartspringjpa.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BlogosphereService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private BlogRepository blogRepository;
	@Autowired private PostRepository postRepository;
	@Autowired private CommentRepository commentRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public List<Blog> findAllBlogs() {
		return blogRepository.findAll();
	}
	
	public List<Post> findAllPosts() {
		return postRepository.findAll();
	}
	
	public List<Comment> findAllComments() {
		return commentRepository.findAll();
	}
}
