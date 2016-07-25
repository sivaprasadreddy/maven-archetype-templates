/**
 * 
 */
package com.sivalabs.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.myapp.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByEmail(String userName);

}
