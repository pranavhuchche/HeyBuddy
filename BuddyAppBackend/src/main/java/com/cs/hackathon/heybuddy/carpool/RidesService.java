package com.cs.hackathon.heybuddy.carpool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RidesService {
	@Autowired
	protected RideDAO rideDAO;

	protected Ride createRide(Ride ride) {
		return rideDAO.createRide(ride);
	}

	protected List<Ride> getAllRides() {
		return rideDAO.getAllRides();
	}
	
	protected Ride getRideById(String id ) {
		return rideDAO.getRideById(id);
	}

}
