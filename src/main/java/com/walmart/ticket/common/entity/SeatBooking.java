package com.walmart.ticket.common.entity;

/**
 * Object that identifies particular booking of a seat for a venue
 */
public class SeatBooking {

	private String id;

	private String holdId;

	private String venueId;

	private String numberOfSeats;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getHoldId() {
		return holdId;
	}

	public void setHoldId(final String holdId) {
		this.holdId = holdId;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(final String venueId) {
		this.venueId = venueId;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(final String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
}
