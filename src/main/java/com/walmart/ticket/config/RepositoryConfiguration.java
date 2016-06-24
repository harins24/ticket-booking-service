package com.walmart.ticket.config;

import com.walmart.ticket.repository.TicketRepository;
import com.walmart.ticket.repository.TicketRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Spring configuration file repositories
 */
@Configuration
public class RepositoryConfiguration {

	@Bean
	public TicketRepository ticketRepository(final DataSource dataSource,
		final Environment environment) {
		final TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl(
			environment.getProperty("query.number.of.seats.by.level"));
		ticketRepository.setDataSource(dataSource);
		return ticketRepository;
	}
}
