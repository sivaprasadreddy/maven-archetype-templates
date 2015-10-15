/**
 * 
 */
package com.sivalabs.myapp.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sivalabs.myapp.entities.User;
import com.sivalabs.myapp.mappers.UserMapper;


/**
 * @author Siva
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userName);
		if(user == null){
			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("USER");
		org.springframework.security.core.userdetails.User secUser = 
				new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
		return secUser;
	}

}
