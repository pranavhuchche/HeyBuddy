package com.cs.hackathon.heybuddy.carpool;

public class Ride {
	private String rideId;
	private String userName;
	private String pickUpLocation;
	private String dropOffLocation;
	private Integer pinCode;
	private VehicleType vehicleType;
	private Long time;
	private Long charges;
	private Integer noOfSeats;
	private boolean isCancelled;

	public final String getRideId() {
		return rideId;
	}

	public final void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public final String getUserName() {
		return userName;
	}

	public final void setUserName(String userName) {
		this.userName = userName;
	}

	public final String getPickUpLocation() {
		return pickUpLocation;
	}

	public final void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public final String getDropOffLocation() {
		return dropOffLocation;
	}

	public final void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public final Integer getPinCode() {
		return pinCode;
	}

	public final void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public final VehicleType getVehicleType() {
		return vehicleType;
	}

	public final void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public final Long getTime() {
		return time;
	}

	public final void setTime(Long time) {
		this.time = time;
	}

	public final Long getCharges() {
		return charges;
	}

	public final void setCharges(long l) {
		this.charges = l;
	}

	public final Integer getNoOfSeats() {
		return noOfSeats;
	}

	public final void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	

	public final boolean isCancelled() {
		return isCancelled;
	}

	public final void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}



	public enum VehicleType {

		UNDEFINED, BIKE, CAR;

		private static final VehicleType[] values = values();

		public static VehicleType valueOf(int ordinal) {
			return values[ordinal];
		}
	}

}
