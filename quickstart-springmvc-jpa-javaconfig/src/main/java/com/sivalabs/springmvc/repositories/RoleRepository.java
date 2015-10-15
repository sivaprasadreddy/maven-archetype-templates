package com.sivalabs.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springmvc.entities.Role;

/**
 * @author Siva
 * 
 */
public interface RoleRepository extends JpaRepository<Role, Integer>
{

}
