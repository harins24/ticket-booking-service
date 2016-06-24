package com.walmart.ticket.config;

import com.walmart.ticket.repository.TicketRepository;
import com.walmart.ticket.service.TicketService;
import com.walmart.ticket.service.TicketServiceImpl;
import com.walmart.ticket.service.TicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration file services
 */
@Configuration
public class ServiceConfiguration {

	@Bean
	public TicketService ticketService(final TicketValidator ticketValidator,
		final TicketRepository ticketRepository) {
		return new TicketServiceImpl(ticketValidator, ticketRepository);
	}
}
