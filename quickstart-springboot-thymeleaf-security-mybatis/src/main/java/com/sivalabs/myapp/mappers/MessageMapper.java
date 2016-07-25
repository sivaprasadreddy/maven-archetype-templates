/**
 * 
 */
package com.sivalabs.myapp.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sivalabs.myapp.entities.Message;

/**
 * @author Siva
 *
 */
public interface MessageMapper 
{

	@Select("select * from users")
	List<Message> findAll();

}
