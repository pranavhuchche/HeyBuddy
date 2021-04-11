package com.cs.hackathon.heybuddy.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setBio(rs.getString("bio"));
		user.setDeskLocation(rs.getString("desk_location"));
		user.setDob(rs.getDate("dob"));
		user.setEmail(rs.getString("email"));
		user.setHobbies(rs.getString("hobbies"));
		user.setMobile(rs.getLong("mobile_number"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		return user;
	}
}
