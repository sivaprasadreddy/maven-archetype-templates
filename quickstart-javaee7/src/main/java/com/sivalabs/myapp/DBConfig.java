/**
 * 
 */
package com.sivalabs.myapp;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author Siva
 *
 */

@Singleton
@Startup
/*
@DataSourceDefinition(
	 name = "java:app/MyApp/MyDS",
     className = "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource",
     portNumber = 3306,
     serverName = "localhost",
     databaseName = "test",
     user = "root",
     password = "admin")
*/
@DataSourceDefinition(
	    name = "java:app/MyApp/MyDS", 
	    className = "org.h2.jdbcx.JdbcDataSource", 
	    url = "jdbc:h2:mem:test"
	)
public class DBConfig {

	@Inject
	UserServiceBean userServiceBean;
	
	@PostConstruct
	void init()
	{
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");
		user.setUserName("Admin");
		
		userServiceBean.create(user);
		
		user = new User();
		user.setEmail("test@gmail.com");
		user.setPassword("test");
		user.setUserName("Test");
		
		userServiceBean.create(user);
	}
}
