/**
 * 
 */
package com.sivalabs.blog.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.domain.Page;

import com.sivalabs.blog.entities.Post;
import com.sivalabs.blog.utils.BeanCopyUtils;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class PostsResponseDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<Post> posts;
	private long totalRecords;
	private int currentPage;
	private int pageSize;
	private boolean hasNextPage;
	private boolean hasPrevPage;
	
	public PostsResponseDTO(List<Post> posts, long totalRecords, int currentPage, int pageSize, boolean hasNextPage, boolean hasPrevPage) {
		this.posts = posts;
		this.totalRecords = totalRecords;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.hasNextPage = hasNextPage;
		this.hasPrevPage = hasPrevPage;
	}

	public PostsResponseDTO(Page<Post> pageData) {
		List<Post> postList = pageData.getContent();
		this.posts = new ArrayList<Post>();
		for (Post post : postList)
		{
			this.posts.add(BeanCopyUtils.copy(post));
		}
		this.totalRecords = pageData.getTotalElements();
		this.currentPage = pageData.getNumber();
		this.pageSize = pageData.getSize();
		this.hasNextPage = pageData.hasNext();
		this.hasPrevPage = pageData.hasPrevious();
	}

	public List<Post> getPosts() {
		return posts;
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
