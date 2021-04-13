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
				"INSERT INTO heybuddy.rides( pick_up_location, drop_off_location, pinCode, vehicle_type, time, charges, no_of_seats, username)");
		query.append(" VALUES ('");
		query.append(ride.getPickUpLocation() + "','");
		query.append(ride.getDropOffLocation() + "',");
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
		StringBuilder query = new StringBuilder("SELECT * FROM heybuddy.rides WHERE ride_id = " + id);
		return jdbcTemplate.queryForObject(query.toString(), new RideRowMapper());
	}

	public List<Ride> searchRide(Ride ride) {
		StringBuilder query = new StringBuilder("Select * from heybuddy.rides r where r.no_of_seats >= ");
		query.append(ride.getNoOfSeats());
		query.append(" AND r.pick_up_location ilike '%");
		query.append(ride.getPickUpLocation());
		query.append("%' AND r.drop_off_location ilike '%");
		query.append(ride.getDropOffLocation() + "%'");
		if (ride.getVehicleType().ordinal() != 0) {
			query.append(" AND vehicle_type = ");			
			query.append(ride.getVehicleType().ordinal());
		}
		query.append(" AND r.is_cancelled = false ");
		return jdbcTemplate.query(query.toString(), new RideRowMapper());
	}
	
	public Ride cancelRide (Long rideId) {
		StringBuilder query = new StringBuilder("UPDATE heybuddy.rides SET is_cancelled = true where ride_id = ? RETURNING *");
		return jdbcTemplate.queryForObject(query.toString(), new Object[] { rideId }, new RideRowMapper());
	}   
}
