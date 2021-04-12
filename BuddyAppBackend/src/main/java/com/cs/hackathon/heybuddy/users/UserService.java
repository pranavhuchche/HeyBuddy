package com.cs.hackathon.heybuddy.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UsersDAO usersDAO;
	
	public User getUserById(String id) {
		return usersDAO.getUserById(id);
	}

	public String validateUser(User user) throws Exception {
		return usersDAO.validateUser(user);
	}
	
	public User createUser(User user) {
		return usersDAO.createUser(user);
	}
	
	public User saveUser(User user) {
		return usersDAO.saveUser(user);
	}
}
