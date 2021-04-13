package com.cs.hackathon.heybuddy.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	protected EventDAO eventDAO;

	protected Event createEvent(Event ride) {
		return eventDAO.createEvent(ride);
	}

	protected List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}
}
