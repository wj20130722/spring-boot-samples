package com.example.myproject.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.myproject.dao.UserDao;
import com.example.myproject.domain.User;

@Repository("userRespostory")
public class UserRespostory implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	public UserRespostory(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	@Override
	public int save(User user) {
		String sql = "insert into user(name,age,sex) values(?,?,?)";
		return this.jdbcTemplate.update(sql, user.getName(),user.getAge(),user.getSex());
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		return this.jdbcTemplate.query(sql, new ActorMapper());
	}

	@Override
	public User findById(int id) {
		String sql = "select * from user where id=?";
		return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, User.class);
	}
	
	private static final class ActorMapper implements RowMapper<User>{  
  
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
			return user;
		}
          
    }

}
