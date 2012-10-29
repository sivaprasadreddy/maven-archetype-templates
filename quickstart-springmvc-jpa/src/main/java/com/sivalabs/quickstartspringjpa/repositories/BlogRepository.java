/**
 * 
 */
package com.sivalabs.quickstartspringjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.quickstartspringjpa.entities.Blog;

/**
 * @author Siva
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Integer>
{

}
