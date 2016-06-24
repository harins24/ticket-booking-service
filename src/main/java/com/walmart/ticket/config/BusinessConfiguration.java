package com.walmart.ticket.config;

import com.walmart.ticket.service.TicketValidator;
import com.walmart.ticket.service.TicketValidatorImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration file for validators and other business related beans
 */
@Configuration
public class BusinessConfiguration {

	@Bean
	public TicketValidator ticketValidator(final MessageSource messageSource) {
		return new TicketValidatorImpl(messageSource);
	}
}
