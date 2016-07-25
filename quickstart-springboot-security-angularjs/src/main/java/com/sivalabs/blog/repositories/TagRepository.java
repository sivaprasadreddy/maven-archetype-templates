package com.sivalabs.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.blog.entities.Tag;


/**
 * @author Siva
 * 
 */
public interface TagRepository extends JpaRepository<Tag, Integer>
{

}
