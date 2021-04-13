package com.cs.hackathon.heybuddy.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Event createEvent(Event event) {
		StringBuilder query = new StringBuilder(
				"INSERT INTO heybuddy.events( discription, time, event_type, event_location, is_transportation_available,"
				+ "charges, participation_type, is_meal_provided, username)");
		query.append(" VALUES ('");
		query.append(event.getDiscription() + "',");
		query.append(event.getTime() + ",");
		query.append(event.getEventType().ordinal() + ",'");
		query.append(event.getLocation()+ "',");
		query.append(event.isTransportationAvailable() + ",");
		query.append(event.getCharges() + ",");
		query.append(event.getParticipationType().ordinal() + ",");
		query.append(event.isMealProvided() + ",'");
		query.append(event.getUserName() + "'");
		query.append(") RETURNING *, username user_name");
		return jdbcTemplate.queryForObject(query.toString(), null, new EventRowMapper());
	}

	public List<Event> getAllEvents() {
		StringBuilder query = new StringBuilder(
				"SELECT e.* , u.name user_name FROM heybuddy.events e INNER JOIN heybuddy.users u ON e.username = u.username ORDER BY time");
		return jdbcTemplate.query(query.toString(), new EventRowMapper());
	}
}
