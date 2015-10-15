/**
 * 
 */
package com.sivalabs.quickstartspring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User findUserById(Integer userId) {
		User user = null;
		user = jdbcTemplate.queryForObject("select * from user where id=?", new Object[]{userId}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("name"));
				return user;
			}});
		return user;
	}

	public List<User> findAllUsers() {
		return jdbcTemplate.query("select * from user", new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("name"));
				return user;
			}}
		); 
	}
}
