/**
 * 
 */
package com.sivalabs.blog.rest.endpoints.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.blog.entities.Tag;
import com.sivalabs.blog.services.TagService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/api/admin")
public class TagsRestController
{
	@Autowired private TagService tagService;
	
	@RequestMapping(value="/tags", method=RequestMethod.POST)
	public Tag createTag(@RequestBody Tag tag)
	{
		return tagService.createTag(tag);
	}
}
