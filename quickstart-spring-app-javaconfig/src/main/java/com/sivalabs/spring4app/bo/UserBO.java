/**
 * 
 */
package com.sivalabs.spring4app.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.spring4app.domain.User;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserBO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User login(String userName, String password) 
	{
		String sql = "select user_id, username, password, email from users where username=? and password=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[]{userName, password}, new UserRowMapper());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<User> findAllUsers() {
		String sql = "select user_id, username, password, email from users";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	public void createUser(User user) {
		String sql = "insert into users(user_id, username, password, email) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{
				user.getId(),
				user.getUserName(),
				user.getPassword(),
				user.getEmail()
		});
	}
}

class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		
		return user;
	}
	
}
