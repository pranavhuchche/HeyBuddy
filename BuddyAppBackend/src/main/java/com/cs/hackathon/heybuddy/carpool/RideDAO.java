package com.cs.hackathon.heybuddy.carpool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RideDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Ride createRide(Ride ride) {
		StringBuilder query = new StringBuilder(
				"INSERT INTO heybuddy.rides( location, pinCode, vehicle_type, time, charges, no_of_seats, username)");
		query.append(" VALUES ('");
		query.append(ride.getLocation() + "',");
		query.append(ride.getPinCode() + ",");
		query.append(ride.getVehicleType().ordinal() + ",");
		query.append(ride.getTime() + ",");
		query.append(ride.getCharges() + ",");
		query.append(ride.getNoOfSeats() + ",'");
		query.append(ride.getUserName() + "'");
		query.append(") RETURNING *");
		return jdbcTemplate.queryForObject(query.toString(), null, new RideRowMapper());
	}

	public List<Ride> getAllRides() {
		StringBuilder query = new StringBuilder("SELECT * FROM heybuddy.rides ORDER BY time");
		return jdbcTemplate.query(query.toString(), new RideRowMapper());
	}
	
	public Ride getRideById(String id) {
		StringBuilder query = new StringBuilder("SELECT * FROM heybuddy.rides WHERE ride_id = " + id + " ORDER BY time");
		return jdbcTemplate.queryForObject(query.toString(), new RideRowMapper());
	}
}
