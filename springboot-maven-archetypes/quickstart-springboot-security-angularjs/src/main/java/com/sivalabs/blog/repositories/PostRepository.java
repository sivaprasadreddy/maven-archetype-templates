package com.sivalabs.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.blog.entities.Post;

/**
 * @author Siva
 * 
 */
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
