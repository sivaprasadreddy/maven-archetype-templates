/**
 * 
 */
package com.sivalabs.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blog.entities.Comment;
import com.sivalabs.blog.entities.Post;
import com.sivalabs.blog.repositories.CommentRepository;
import com.sivalabs.blog.repositories.PostRepository;
import com.sivalabs.blog.rest.model.PostsRequestDTO;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BlogService 
{
	@Autowired PostRepository postRepository;
	@Autowired CommentRepository commentRepository;
	
	public Page<Post> findPosts(PostsRequestDTO postsRequest) 
	{
		Sort sort = new Sort(Direction.DESC, "createdOn");
		if(postsRequest.getPageNo() < 0){
			postsRequest.setPageNo(0);
		}
		if(postsRequest.getPageSize() < 1) {
			postsRequest.setPageSize(5);
		}
		Pageable pageable = new PageRequest(postsRequest.getPageNo(), postsRequest.getPageSize(), sort);
		Page<Post> pageData = postRepository.findAll(pageable);
		
		return pageData;
	}
	
	public Post findPostById(int postId) {
		return postRepository.findOne(postId);
	}
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
		
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

	public void deletePost(Integer postId)
	{
		postRepository.delete(postId);
	}

	public Page<Comment> findComments(PostsRequestDTO request)
	{
		Sort sort = new Sort(Direction.DESC, "createdOn");
		if(request.getPageNo() < 0){
			request.setPageNo(0);
		}
		if(request.getPageSize() < 1) {
			request.setPageSize(5);
		}
		Pageable pageable = new PageRequest(request.getPageNo(), request.getPageSize(), sort);
		Page<Comment> pageData = commentRepository.findAll(pageable);
		
		return pageData;
	}

	public void deleteComment(Integer commentId)
	{
		commentRepository.delete(commentId);
	}

}
