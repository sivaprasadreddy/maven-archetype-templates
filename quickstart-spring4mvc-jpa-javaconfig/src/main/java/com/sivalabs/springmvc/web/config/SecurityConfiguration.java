/**
 * 
 */
package com.sivalabs.springmvc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Siva
 *
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		registry.userDetailsService(userDetailsService);
    }
	

	  @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**");
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .antMatchers("/login","/register","/logout").permitAll()
	        .antMatchers("/admin","/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	    .formLogin()
	        .loginProcessingUrl("/login")
	        .permitAll();
	  }
}
