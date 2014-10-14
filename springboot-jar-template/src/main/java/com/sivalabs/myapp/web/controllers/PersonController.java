/**
*
*
*/
package com.sivalabs.myapp.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.myapp.entities.Person;
import com.sivalabs.myapp.repositories.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController
{
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Person> list()
	{
		return personRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Person get(@PathVariable Integer id)
	{
		return personRepository.findOne(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Person create(@RequestBody Person person)
	{
		return personRepository.save(person);
	}
}
