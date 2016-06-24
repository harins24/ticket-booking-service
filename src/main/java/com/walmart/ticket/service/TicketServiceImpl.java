package com.walmart.ticket.service;

import com.walmart.ticket.common.entity.SeatHold;
import com.walmart.ticket.common.entity.Venue;
import com.walmart.ticket.repository.TicketRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Default implementation class for {@link TicketService}
 */
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = LogManager.getLogger(
		TicketServiceImpl.class);

	private final TicketValidator ticketValidator;

	private final TicketRepository ticketRepository;

	public TicketServiceImpl(final TicketValidator ticketValidator,
		final TicketRepository ticketRepository) {
		this.ticketValidator = ticketValidator;
		this.ticketRepository = ticketRepository;
	}

	@Override
	public int numSeatsAvailable(final String venueLevel) {
		LOGGER.debug("Finding number of seats available for the venue level {}",
			venueLevel);
		ticketValidator.throwExceptionIfLevelNotValid(venueLevel);
		Venue venue = ticketRepository.findOne(Integer.valueOf(venueLevel));
		final int availableSeats = venue.getSeatsInRow() * venue.getRows();
		LOGGER.debug("Number of seats available for the venue {} are {}",
			venueLevel, availableSeats);
		return availableSeats;
	}

	@Override
	public SeatHold findAndHoldSeats(final String numSeats,
		final String minLevel, final String maxLevel,
		final String customerEmail) {
		return null;
	}

	@Override
	public String reserveSeats(final int seatHoldId,
		final String customerEmail) {
		return null;
	}
}
