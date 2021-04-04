package com.cs.hackathon.heybuddy.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetupDatabaseController {
	
	@Autowired
	SetupDatabaseService setupDatabaseService;

	@GetMapping("/setupdb")
	public void setUpDatabase() throws Exception {
		setupDatabaseService.execute();
	}
}
