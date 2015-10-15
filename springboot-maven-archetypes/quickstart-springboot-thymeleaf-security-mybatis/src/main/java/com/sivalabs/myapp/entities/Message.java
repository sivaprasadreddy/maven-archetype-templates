/**
 * 
 */
package com.sivalabs.myapp.entities;

import java.util.Date;

/**
 * @author Siva
 *
 */
public class Message
{
	private Integer id;
	private String content;
	private Date createdOn;
	private User createdBy;
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getCreatedOn()
	{
		return createdOn;
	}
	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}
	public User getCreatedBy()
	{
		return createdBy;
	}
	public void setCreatedBy(User createdBy)
	{
		this.createdBy = createdBy;
	}

	
}
