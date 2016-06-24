package com.walmart.ticket.controller.entity;

/**
 * UI entity that stores the data for seat hold request for input level range minimum and maximum
 */
public class SeatHoldRequest {

	String numSeats;

	String email;

	String minLevel;

	String maxLevel;

	public String getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(final String numSeats) {
		this.numSeats = numSeats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(final String minLevel) {
		this.minLevel = minLevel;
	}

	public String getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(final String maxLevel) {
		this.maxLevel = maxLevel;
	}

	@Override
	public String toString() {
		return "SeatHoldRequest{" +
			"numSeats='" + numSeats +
			"', email='" + email +
			"', minLevel='" + minLevel +
			"', maxLevel='" + maxLevel +
			"'}";
	}
}
