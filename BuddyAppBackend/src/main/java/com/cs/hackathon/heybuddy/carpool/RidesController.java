package com.cs.hackathon.heybuddy.carpool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RidesController {
	@Autowired
	protected RidesService ridesService;

	@PostMapping("/createride")
	public Ride createRide(@RequestBody Ride ride, @RequestHeader(value = "user") String username) {
		ride.setUserName(username);
		return ridesService.createRide(ride);
	}
	
	@PostMapping("/searchride")
	public List<Ride> searchRide(@RequestBody Ride ride) {
		return ridesService.searchRide(ride);
	}

	@GetMapping("/getrides/all")
	public List<Ride> getAllRides() {
		return ridesService.getAllRides();
	}

	@GetMapping("/getride/{id}")
	public Ride getRideById(@PathVariable String id) {
		return ridesService.getRideById(id);
	}
	
	@PutMapping("/cancelride/{id}")
	public Ride cancelRide (@PathVariable Long id) {
		return ridesService.cancelRide(id);
	}
}
