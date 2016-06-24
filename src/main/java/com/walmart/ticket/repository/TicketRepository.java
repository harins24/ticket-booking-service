package com.walmart.ticket.repository;

import com.walmart.ticket.common.entity.Venue;

/**
 * Repository interface for booking related functions
 */
public interface TicketRepository {

	Venue findOne(Integer venueLevel);
}
