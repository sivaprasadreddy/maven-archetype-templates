/**
 * 
 */
package com.sivalabs.quickstartspringjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.quickstartspringjpa.entities.Comment;

/**
 * @author Siva
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>
{

}
