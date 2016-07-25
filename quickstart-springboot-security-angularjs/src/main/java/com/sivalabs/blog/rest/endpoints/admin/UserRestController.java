/**
 * 
 */
package com.sivalabs.blog.rest.endpoints.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.blog.rest.model.AuthenticatedUser;
import com.sivalabs.blog.security.SecurityUser;
import com.sivalabs.blog.services.UserService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/api/users/", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserRestController 
{
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/authenticatedUser", method=RequestMethod.GET)
	public ResponseEntity<AuthenticatedUser> getAuthenticatedUser() 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!= null)
		{
			Object userDetails = authentication.getPrincipal();
			if(userDetails != null && userDetails instanceof SecurityUser)
			{
				SecurityUser secUser = (SecurityUser) userDetails;
				String username = secUser.getUsername();
				List<String> roles = Arrays.asList(secUser.getDomainUser().getRole());
				AuthenticatedUser authenticatedUser = new AuthenticatedUser(username, roles);
				return new ResponseEntity<AuthenticatedUser>(authenticatedUser,HttpStatus.OK); 
			}
		}
		return new ResponseEntity<AuthenticatedUser>(HttpStatus.UNAUTHORIZED);
		
	}
}
