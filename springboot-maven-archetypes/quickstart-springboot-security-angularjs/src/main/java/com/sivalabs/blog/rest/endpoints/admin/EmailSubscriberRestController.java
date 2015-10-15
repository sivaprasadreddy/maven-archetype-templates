/**
 * 
 */
package com.sivalabs.blog.rest.endpoints.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.blog.entities.EmailSubscriber;
import com.sivalabs.blog.repositories.EmailSubscriberRepository;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/api/admin")
public class EmailSubscriberRestController
{
	private final static Logger logger = LoggerFactory.getLogger(EmailSubscriberRestController.class);
	
	@Autowired private EmailSubscriberRepository emailSubscriberRepository;
	
	@RequestMapping(value="/emailSubscribers", method=RequestMethod.GET)
	public List<EmailSubscriber> findAllEmailSubscribers()
	{
		return emailSubscriberRepository.findAll();
	}
	
	@RequestMapping(value="/emailSubscribers/{email}", method=RequestMethod.DELETE)
	public void deleteEmailSubscriber(@PathVariable("email") String email)
	{
		logger.debug("Deleting EmailSubscriber : "+email);
		EmailSubscriber subscriber = emailSubscriberRepository.findByEmail(email);
		if(subscriber != null)
		{
			emailSubscriberRepository.delete(subscriber);
		}
	}
}
