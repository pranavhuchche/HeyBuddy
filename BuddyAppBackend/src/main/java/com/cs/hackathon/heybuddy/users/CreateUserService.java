package com.cs.hackathon.heybuddy.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
	
	@Autowired
	UsersDAO usersDAO;
	
	public User createUser(User user) {
		return usersDAO.createUser(user);
	}
}
