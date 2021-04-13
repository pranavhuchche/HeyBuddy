package com.cs.hackathon.heybuddy.users;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UsersDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUserById(String id) {
		String query = "SELECT * FROM heybuddy.users WHERE username = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new UserRowMapper());
	}
	
	public User createUser(User user) {
		StringBuilder query = new StringBuilder("INSERT INTO heybuddy.users(username, name, dob, bio, mobile_number,"
				+ " desk_location, email, hobbies, password) VALUES ('");
		query.append(user.getUsername() + "','");
		query.append(user.getName() + "','");
		query.append(user.getDob() + "','");
		query.append(user.getBio() + "','");
		query.append(user.getMobile() + "','");
		query.append(user.getDeskLocation() + "','");
		query.append(user.getEmail() + "','");
		query.append(user.getHobbies() + "','");
		query.append(hashPassword(user.getPassword()) + "'");
		query.append(") RETURNING *");
		
		return jdbcTemplate.queryForObject(query.toString(), null, new UserRowMapper());
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public Map<String, String> validateUser(User user) throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		StringBuilder query = new StringBuilder("Select u.password from heybuddy.users u where u.username = ?");
		String hashedPassword = jdbcTemplate.queryForObject(query.toString(), new Object[] {username}, String.class);
		if(hashedPassword == null || "".equals(hashedPassword) || !checkPassword(password, hashedPassword)) {
			throw new Exception("User or Password is incorrect.");
		}
		Map<String,String> response = new HashMap<>();
		response.put("username ", username);
		return response;
	}
	
	private boolean checkPassword(String plainPassword, String hashedPassword) {
		return (BCrypt.checkpw(plainPassword, hashedPassword)) ? true : false;
	}
	
	public User saveUser(User user) {
		StringBuilder query = new StringBuilder("UPDATE  heybuddy.users set  name = ?, dob = ?, bio = ?, mobile_number = ?,"
				+ " desk_location = ?, email = ?, hobbies = ?, password = ? where username = '"+ user.getUsername() + "' RETURNING * ");
		Object[] args = {user.getName(), user.getDob(), user.getBio(), user.getMobile(),
				user.getDeskLocation(), user.getEmail(), user.getHobbies(), hashPassword(user.getPassword())};
		return jdbcTemplate.queryForObject(query.toString(), args, new UserRowMapper());
	}

}
