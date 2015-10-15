/**
 * 
 */
package com.sivalabs.blog.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "POSTS")
public class Post implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer id;
	@Column(name = "title", nullable = false, length = 150)
	private String title;
	@Lob
	@Column(name = "content", nullable = false, columnDefinition="TEXT")
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;
	
	@ManyToMany
	@JoinTable(
	      name="POSTS_TAGS",
	      joinColumns={@JoinColumn(name="POST_ID", referencedColumnName="POST_ID")},
	      inverseJoinColumns={@JoinColumn(name="TAG_ID", referencedColumnName="TAG_ID")}
	      )
	private List<Tag> tags;
	
	@OneToMany(mappedBy="post", cascade=CascadeType.REMOVE)
	private List<Comment> comments = new ArrayList<>();
	
	public Post() {
	}
	public Post(Integer postId) {
		this.id = postId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getContentPreview()
	{
		if(content == null || content.trim().length() <= 250){
			return content;
		}
		return content.substring(0, 250).concat(" ...");
	}
	public List<Tag> getTags()
	{
		return tags;
	}
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
	
	
}
