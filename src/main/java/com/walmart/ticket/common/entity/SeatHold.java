package com.walmart.ticket.common.entity;

import java.time.ZonedDateTime;

/**
 * Object that identifies the specific seats and related information
 */
public class SeatHold {

	private String id;

	private String customerEmail;

	private ZonedDateTime holdTime;

	private String bookingCode;

	private ZonedDateTime bookingTime;

	private String seatBookingId;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(final String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public ZonedDateTime getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(final ZonedDateTime holdTime) {
		this.holdTime = holdTime;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(final String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public ZonedDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(final ZonedDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getSeatBookingId() {
		return seatBookingId;
	}

	public void setSeatBookingId(final String seatBookingId) {
		this.seatBookingId = seatBookingId;
	}
}
