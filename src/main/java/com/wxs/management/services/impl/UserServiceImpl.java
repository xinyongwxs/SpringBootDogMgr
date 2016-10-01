package com.wxs.management.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wxs.management.models.User;
import com.wxs.management.services.UserService;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		User user = new User();
		user = jdbcTemplate.queryForObject("select * from user where name=?", 
				new UserRowMapper(), 
				name);
		return user;
	}
	
	class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setGender(rs.getString("gender"));
			user.setPosition(rs.getString("position"));
			user.setAge(rs.getInt("age"));
			user.setName(rs.getString("name"));
			return user;
		}}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
       user.setId(uuid.toString());
       List<String> inParams = new ArrayList<String>();
       inParams.add(user.getId());
       inParams.add(user.getName());
       inParams.add(user.getPosition());
       inParams.add(user.getGender());
       inParams.add(Integer.toString(user.getAge()));
       jdbcTemplate.update("INSERT INTO dogdb.user values (?, ?, ?, ?, ?)", inParams.toArray());
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
//		User test1 = new User(123L, "wxs", 21, "high");
		List<User> result = new ArrayList<User>();
//		result.add(test1);
		return result;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
