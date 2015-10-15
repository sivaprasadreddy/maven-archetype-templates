/**
 * 
 */
package com.sivalabs.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.sivalabs.blog.model.EmailEvent;

/**
 * @author Siva
 *
 */
@Component
public class EmailService implements ApplicationEventPublisherAware, ApplicationListener<EmailEvent>
{
	@Autowired JavaMailSender javaMailSender;
	@Value("${support.email}") String supportEmail;
	
	private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    
    @Override
	public void onApplicationEvent(EmailEvent event)
	{
		this.send(event.getSubject(), event.getContent());
	}
    
    public void sendEmail(String subject, String content)
	{
    	EmailEvent event = new EmailEvent(this, subject, content);
		publisher.publishEvent(event);
	}
    
	private void send(String subject, String content)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(supportEmail);
        mailMessage.setReplyTo(supportEmail);
        mailMessage.setFrom(supportEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);      
		
        try
		{
			javaMailSender.send(mailMessage);
		} catch (MailException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
