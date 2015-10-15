/**
 * 
 */
package com.sivalabs.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.*;
import static com.google.common.base.Predicates.*;
/**
 * @author Siva
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
	@Bean
	  public Docket swaggerSpringMvcPlugin() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            //.groupName("business-api")
	    		//.pathMapping("/")
	            .select()
	              .paths(paths())
	              .build()
	              .apiInfo(apiInfo())
	              
	            ;
	  }

	  private ApiInfo apiInfo() {
		return new ApiInfo("My Bootiful Spring App Demo", "My Bootiful Spring App Demo", "1.0", null, "siva@gmail.com", null, null);
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
	    return or(
	        regex("/*.*"));
	}
    
	
}
