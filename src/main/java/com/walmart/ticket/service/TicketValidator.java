package com.walmart.ticket.service;

/**
 * Interface for validating inputs
 */
public interface TicketValidator {

	void throwExceptionIfLevelNotValid(String venueLevel);
}
