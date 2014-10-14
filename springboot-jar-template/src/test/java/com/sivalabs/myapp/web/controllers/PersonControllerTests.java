/**
*
*
*/
package com.sivalabs.myapp.web.controllers;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sivalabs.myapp.Application;
import com.sivalabs.myapp.entities.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class PersonControllerTests
{
	public static final String baseUrl = "http://localhost:8080/myapp/api";
	
	@Test
	public void test_list()
	{
		RestTemplate rt = new RestTemplate();
		String url = baseUrl+"/persons/";
		ResponseEntity<Person[]> responseEntity = rt.getForEntity(url , Person[].class);
		Person[] persons = responseEntity.getBody();
		Assert.assertEquals(3, persons.length);
	}
	
	@Test
	public void test_get()
	{
		RestTemplate rt = new RestTemplate();
		String url = baseUrl+"/persons/1";
		ResponseEntity<Person> responseEntity = rt.getForEntity(url , Person.class);
		Person person = responseEntity.getBody();
		Assert.assertNotNull(person);
	}
	
	@Test
	public void test_create()
	{
		RestTemplate rt = new RestTemplate();
		String url = baseUrl+"/persons/";
		Person person = new Person();
		person.setEmail("bot@gmail.com");
		person.setPassword("secret");
		person.setName("SuperBot");
		person.setDob(new Date());
		
		ResponseEntity<Person> responseEntity = rt.postForEntity(url , person, Person.class);
		person = responseEntity.getBody();
		Assert.assertNotNull(person);
		System.out.println(person.getId());
	}
	
	
	
	
}
