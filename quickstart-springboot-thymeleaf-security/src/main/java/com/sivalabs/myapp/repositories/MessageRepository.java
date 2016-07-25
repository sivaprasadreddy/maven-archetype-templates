/**
 * 
 */
package com.sivalabs.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.myapp.entities.Message;

/**
 * @author Siva
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>
{

}
