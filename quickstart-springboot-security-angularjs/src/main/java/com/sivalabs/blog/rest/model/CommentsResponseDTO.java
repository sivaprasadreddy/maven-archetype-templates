/**
 * 
 */
package com.sivalabs.blog.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;

import com.sivalabs.blog.entities.Comment;
import com.sivalabs.blog.utils.BeanCopyUtils;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class CommentsResponseDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<Comment> comments;
	private long totalRecords;
	private int currentPage;
	private int pageSize;
	private boolean hasNextPage;
	private boolean hasPrevPage;
	
	public CommentsResponseDTO(List<Comment> comments, long totalRecords, int currentPage, int pageSize, boolean hasNextPage, boolean hasPrevPage) {
		this.comments = comments;
		this.totalRecords = totalRecords;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.hasNextPage = hasNextPage;
		this.hasPrevPage = hasPrevPage;
	}

	public CommentsResponseDTO(Page<Comment> pageData) {
		List<Comment> commentList = pageData.getContent();
		this.comments = new ArrayList<Comment>();
		for (Comment comment : commentList)
		{
			this.comments.add(BeanCopyUtils.copy(comment));
		}
		this.totalRecords = pageData.getTotalElements();
		this.currentPage = pageData.getNumber();
		this.pageSize = pageData.getSize();
		this.hasNextPage = pageData.hasNext();
		this.hasPrevPage = pageData.hasPrevious();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}
	
}
