/**
 * 
 */
package com.sivalabs.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blog.entities.Tag;
import com.sivalabs.blog.repositories.TagRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class TagService
{
	@Autowired private TagRepository tagRepository;
	
	public List<Tag> findAllTags()
	{
		return tagRepository.findAll();
	}
	
	public Tag createTag(Tag tag)
	{
		return tagRepository.save(tag);
	}
	
	
}
