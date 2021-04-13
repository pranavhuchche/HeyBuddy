package com.cs.hackathon.heybuddy.events;

public class Event {
    private Long eventId;
	private String discription;
	private Long time;
	private String location;
	private boolean isTransportationAvailable;
	private Long charges;
	private boolean isMealProvided;
	private EventType eventType;
	private ParticipationType participationType;
	private boolean isClosed;
    private String username;
    
	public final Long getEventId() {
		return eventId;
	}

	public final void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public final String getDiscription() {
		return discription;
	}

	public final void setDiscription(String discription) {
		this.discription = discription;
	}

	public final Long getTime() {
		return time;
	}

	public final void setTime(Long time) {
		this.time = time;
	}

	public final String getLocation() {
		return location;
	}

	public final void setLocation(String location) {
		this.location = location;
	}

	public final boolean isTransportationAvailable() {
		return isTransportationAvailable;
	}

	public final void setTransportationAvailable(boolean isTransportationAvailable) {
		this.isTransportationAvailable = isTransportationAvailable;
	}

	public final Long getCharges() {
		return charges;
	}

	public final void setCharges(Long charges) {
		this.charges = charges;
	}

	public final boolean isMealProvided() {
		return isMealProvided;
	}

	public final void setMealProvided(boolean isMealProvided) {
		this.isMealProvided = isMealProvided;
	}

	public final EventType getEventType() {
		return eventType;
	}

	public final void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public final ParticipationType getParticipationType() {
		return participationType;
	}

	public final void setParticipationType(ParticipationType participationType) {
		this.participationType = participationType;
	}
	
	public final boolean isClosed() {
		return isClosed;
	}

	public final void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public final String getUserName() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}



	public enum EventType {

		UNDEFINED, ONLINE, PHYSICAL;

		private static final EventType[] values = values();

		public static EventType valueOf(int ordinal) {
			return values[ordinal];
		}
	}

	public enum ParticipationType {

		UNDEFINED, INDIVIDUAL, TEAM;

		private static final ParticipationType[] values = values();

		public static ParticipationType valueOf(int ordinal) {
			return values[ordinal];
		}
	}

}
