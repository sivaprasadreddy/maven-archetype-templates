package com.sivalabs.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.blog.entities.EmailSubscriber;


/**
 * @author Siva
 * 
 */
public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber, Integer>
{

	EmailSubscriber findByEmail(String email);

}
