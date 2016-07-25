/**
 * 
 */
package com.sivalabs.blog.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.sivalabs.blog.entities.User;


/**
 * @author Siva
 *
 */
public class SecurityUser implements UserDetails
{
	private static final long serialVersionUID = 1L;
	private User domainUser;
	
	public SecurityUser(User user)
	{
		this.domainUser = user;
	}
	public User getDomainUser()
	{
		return domainUser;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return AuthorityUtils.createAuthorityList(domainUser.getRole());
	}

	@Override
	public String getPassword()
	{
		return domainUser.getPassword();
	}

	@Override
	public String getUsername()
	{
		return domainUser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
