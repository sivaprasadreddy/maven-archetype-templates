/**
 * 
 */
package com.sivalabs.blog.model;

import org.springframework.context.ApplicationEvent;

/**
 * @author Siva
 *
 */
public class EmailEvent extends ApplicationEvent
{
	private static final long serialVersionUID = 1L;
	private String subject;
	private String content;
	
	public EmailEvent(Object source, String subject, String content)
	{
		super(source);
		this.subject = subject;
		this.content = content;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
	
	

}
