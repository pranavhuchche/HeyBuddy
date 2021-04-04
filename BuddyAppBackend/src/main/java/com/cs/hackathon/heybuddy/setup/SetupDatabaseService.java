package com.cs.hackathon.heybuddy.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupDatabaseService {
	
	@Autowired
	private SetupDatabaseDAO setupDatabaseDAO;

	protected void execute() throws Exception {
		setupDatabaseDAO.execute();
	}

}
