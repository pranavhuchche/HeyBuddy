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
	UserService userService;

	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable String id) throws Exception {
		return userService.getUserById(id);
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) throws Exception {
		return userService.createUser(user);
	}
	
	@PostMapping("/validateuser")
	public String validateUser(@RequestBody User user) throws Exception {
		return userService.validateUser(user);
	}
	
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}
}