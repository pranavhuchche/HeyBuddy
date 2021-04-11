package com.cs.hackathon.heybuddy.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	GetUserService getUserService;
	
	@Autowired
	CreateUserService createUserService;

	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable String id) throws Exception {
		return getUserService.getUserById(id);
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) throws Exception {
		return createUserService.createUser(user);
	}
	
	@PostMapping("/validateuser")
	public String validateUser(@RequestBody User user) throws Exception {
		return getUserService.validateUser(user);
	}
}