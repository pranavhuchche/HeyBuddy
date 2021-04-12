package com.cs.hackathon.heybuddy.carpool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cs.hackathon.heybuddy.carpool.Ride.VehicleType;

public class RideRowMapper implements RowMapper<Ride> {

	@Override
	public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ride ride = new Ride();
		ride.setRideId(rs.getString("ride_id"));
		ride.setPickUpLocation(rs.getString("pick_up_location"));
		ride.setDropOffLocation(rs.getString("drop_off_location"));
		ride.setPinCode(rs.getInt("pinCode"));
		ride.setVehicleType(VehicleType.valueOf(rs.getInt("vehicle_type")));
		ride.setTime(rs.getLong("time"));
		ride.setCharges(rs.getLong("charges"));
		ride.setNoOfSeats(rs.getInt("no_of_seats"));
		ride.setUserName(rs.getString("username"));
		return ride;
	}

}
