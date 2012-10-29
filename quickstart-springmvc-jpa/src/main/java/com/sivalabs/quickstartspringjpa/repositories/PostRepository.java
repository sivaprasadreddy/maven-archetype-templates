/**
 * 
 */
package com.sivalabs.quickstartspringjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.quickstartspringjpa.entities.Post;

/**
 * @author Siva
 *
 */
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
