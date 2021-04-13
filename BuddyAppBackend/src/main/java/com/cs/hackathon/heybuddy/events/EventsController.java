package com.cs.hackathon.heybuddy.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {
	@Autowired
	protected EventService eventService;

	@PostMapping("/createevent")
	public Event createEvent(@RequestBody Event event, @RequestHeader(value = "user") String username) {
		event.setUsername(username);
		return eventService.createEvent(event);
	}
	

	@GetMapping("/getevent/all")
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}
}
