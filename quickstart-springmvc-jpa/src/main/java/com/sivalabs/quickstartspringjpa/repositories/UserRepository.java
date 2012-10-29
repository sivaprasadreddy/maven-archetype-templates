/**
 * 
 */
package com.sivalabs.quickstartspringjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.quickstartspringjpa.entities.User;

/**
 * @author Siva
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>
{

}
