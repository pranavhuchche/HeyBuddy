package com.cs.hackathon.heybuddy.events;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cs.hackathon.heybuddy.events.Event.EventType;
import com.cs.hackathon.heybuddy.events.Event.ParticipationType;

public class EventRowMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event event = new Event();
		event.setEventId(rs.getLong("event_id"));
		event.setDiscription(rs.getString("discription"));
		event.setTime(rs.getLong("time"));
		event.setEventType(EventType.valueOf(rs.getInt("event_type")));
		event.setLocation(rs.getString("event_location"));
		event.setTransportationAvailable(rs.getBoolean("is_transportation_available"));
		event.setCharges(rs.getLong("charges"));
		event.setParticipationType(ParticipationType.valueOf(rs.getInt("participation_type")));
		event.setMealProvided(rs.getBoolean("is_meal_provided"));
		event.setClosed(rs.getBoolean("is_closed"));
		event.setUsername(rs.getString("user_name"));
		return event;
	}
}
