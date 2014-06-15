package com.sivalabs.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springmvc.entities.User;

/**
 * @author Siva
 * 
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String email);


	User findByEmailAndPassword(String email, String password);

}
