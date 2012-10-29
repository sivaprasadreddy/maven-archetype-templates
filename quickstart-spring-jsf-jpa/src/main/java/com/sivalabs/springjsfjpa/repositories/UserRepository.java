/**
 * 
 */
package com.sivalabs.springjsfjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springjsfjpa.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

}
