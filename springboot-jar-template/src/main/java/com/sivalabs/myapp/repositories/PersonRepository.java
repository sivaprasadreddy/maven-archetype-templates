/**
*
*
*/
package com.sivalabs.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.myapp.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>
{

}
