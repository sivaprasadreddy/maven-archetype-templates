/**
 * 
 */
package com.sivalabs.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sivalabs.blog.security.AuthFailureHandler;
import com.sivalabs.blog.security.AuthSuccessHandler;
import com.sivalabs.blog.security.CustomUserDetailsService;
import com.sivalabs.blog.security.HttpAuthenticationEntryPoint;
import com.sivalabs.blog.security.HttpLogoutSuccessHandler;

/**
 * @author Siva
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String LOGIN_PATH = "/authenticate";

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private HttpAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthSuccessHandler authSuccessHandler;
    @Autowired
    private AuthFailureHandler authFailureHandler;
    @Autowired
    private HttpLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        //authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/webjars/**","/resources/**","/templates/**");
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
	    	//.authorizeUrls()
	        .authorizeRequests()
	        .antMatchers("/","/about","/contact").permitAll()
	        .antMatchers("/api/admin/**").hasRole("ADMIN")
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        //.anyRequest().authenticated()
	        ;
    	
        http.csrf().disable()
                .authenticationProvider(authenticationProvider())
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .formLogin()
                .permitAll()
                .loginProcessingUrl(LOGIN_PATH)
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
                .logout()
                .permitAll()
                //.logoutRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, "DELETE"))
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .sessionManagement()
                .maximumSessions(1);
        
        
        
       // http.authorizeRequests().anyRequest().authenticated();
    }
}

