/**
 * 
 */
package com.sivalabs.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Siva
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class BlogApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}

