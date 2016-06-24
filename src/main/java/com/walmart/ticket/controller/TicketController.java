package com.walmart.ticket.controller;

import com.walmart.ticket.common.entity.SeatHold;
import com.walmart.ticket.controller.entity.SeatHoldReply;
import com.walmart.ticket.controller.entity.SeatHoldRequest;
import com.walmart.ticket.service.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest interface for ticket bookings
 */
@RestController
public class TicketController {

	private static final Logger LOGGER = LogManager.getLogger(
		TicketController.class);

	private final TicketService ticketService;

	public TicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@RequestMapping(value = "/v1/level/{levelId}/seatsAvailable", method = RequestMethod.GET)
	public int seatsAvailable(@PathVariable final String levelId) {
		LOGGER.debug("Finding number of seats available for level {}", levelId);
		final int numSeatsAvailable = ticketService.numSeatsAvailable(levelId);
		LOGGER.debug("Number of seats available for level {} are {}", levelId,
			numSeatsAvailable);
		return numSeatsAvailable;
	}

	@RequestMapping(value = "/v1/hold-seats", method = RequestMethod.POST)
	public ResponseEntity<SeatHoldReply> findAndHoldSeats(
		@RequestBody final SeatHoldRequest seatHoldRequest) {
		LOGGER.debug("Received request for seat hold with input {}",
			seatHoldRequest);
		final SeatHold seatHold = ticketService.findAndHoldSeats(
			seatHoldRequest.getNumSeats(), seatHoldRequest.getMinLevel(),
			seatHoldRequest.getMaxLevel(), seatHoldRequest.getEmail());
		final SeatHoldReply seatHoldReply;
		if (seatHold != null) {
			seatHoldReply = new SeatHoldReply(seatHold.getId(),
				seatHold.getCustomerEmail());
			return new ResponseEntity<>(seatHoldReply, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
