/**
 * 
 */
package com.sivalabs.myapp;

/**
 * @author katsi02
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application 
{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}