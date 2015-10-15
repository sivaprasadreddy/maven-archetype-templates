package com.sivalabs.springmvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springmvc.entities.Message;

/**
 * @author Siva
 * 
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

	List<Message> findByPostedById(int userId);

}
