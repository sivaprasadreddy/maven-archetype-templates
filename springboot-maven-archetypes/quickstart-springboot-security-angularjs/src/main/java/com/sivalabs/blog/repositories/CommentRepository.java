package com.sivalabs.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.blog.entities.Comment;

/**
 * @author Siva
 * 
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>
{

}
