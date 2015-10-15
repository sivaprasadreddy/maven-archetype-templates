/**
 * 
 */
package com.sivalabs.myapp.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sivalabs.myapp.entities.User;

/**
 * @author Siva
 *
 */
public interface UserMapper 
{

	@Select("SELECT * FROM users WHERE email = #{email}")
	User findByEmail(String email);

	@Insert("insert into users (name, email, password) values(#{name},#{email},#{password})")
	void save(User user);

}
