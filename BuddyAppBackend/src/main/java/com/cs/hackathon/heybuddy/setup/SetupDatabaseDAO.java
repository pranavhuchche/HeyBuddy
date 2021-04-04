package com.cs.hackathon.heybuddy.setup;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class SetupDatabaseDAO {
	
	@Autowired
	private DataSource dataSource;

	protected void execute() throws Exception {
		Resource resource = new ClassPathResource("DDL.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(dataSource);
	}
}
