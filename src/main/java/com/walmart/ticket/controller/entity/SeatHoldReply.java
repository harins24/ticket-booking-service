package com.walmart.ticket.controller.entity;

/**
 * UI entity that stores seat hold id and corresponding customer email
 */
public class SeatHoldReply {

	private String id;

	private String customerEmail;

	public SeatHoldReply(final String id, final String customerEmail) {
		this.id = id;
		this.customerEmail = customerEmail;
	}

	public String getId() {
		return id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
}
