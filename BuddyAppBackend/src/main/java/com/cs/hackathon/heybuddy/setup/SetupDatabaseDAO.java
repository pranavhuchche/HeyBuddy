package com.cs.hackathon.heybuddy.setup;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

@Component
public class SetupDatabaseDAO {

	@Autowired
	private DataSource dataSource;

	protected void execute() throws Exception {
		dataSource.getConnection();
		Resource resourceSchemaCreation = new ClassPathResource("DDL.sql");
		Resource resourceUsers = new ClassPathResource("UsersDDL.sql");
		Resource resourceProducts = new ClassPathResource("ProductsDDL.sql");
		Resource resourceUsersProducts = new ClassPathResource("UserProductInterestDDL.sql");
		Resource resourceRides = new ClassPathResource("RidesDLL.sql");
		Resource resourceEvents = new ClassPathResource("EventsDLL.sql");

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScripts(resourceSchemaCreation, resourceUsers, resourceProducts, resourceUsersProducts,
				resourceRides, resourceEvents);
		databasePopulator.execute(dataSource);
	}

	public void executeSqlScript(Resource resource) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			connection.setAutoCommit(false);
			ScriptUtils.executeSqlScript(connection, resource);
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
		} finally {
			connection.close();
		}
	}
}
