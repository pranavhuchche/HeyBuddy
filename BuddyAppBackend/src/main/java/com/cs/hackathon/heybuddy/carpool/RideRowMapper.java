package com.cs.hackathon.heybuddy.carpool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cs.hackathon.heybuddy.carpool.Ride.VehicleType;

public class RideRowMapper implements RowMapper<Ride> {

	@Override
	public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ride ride = new Ride();
		ride.setRideId(rs.getString(1));
		ride.setLocation(rs.getString(2));
		ride.setPinCode(rs.getInt(3));
		ride.setVehicleType(VehicleType.valueOf(rs.getInt(4)));
		ride.setTime(rs.getLong(5));
		ride.setCharges(rs.getLong(6));
		ride.setNoOfSeats(rs.getInt(7));
		ride.setUserName(rs.getString(8));
		return ride;
	}

}
