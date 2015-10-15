/**
 * 
 */
package com.sivalabs.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.blog.entities.User;
import com.sivalabs.blog.repositories.UserRepository;


/**
 * @author Siva
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException
	{
		User user = repo.findByEmail(email);
		System.out.println("Email: "+email+", User: "+user);
		if(user == null) throw new UsernameNotFoundException("User not found");
		return new SecurityUser(user);
	}

}
