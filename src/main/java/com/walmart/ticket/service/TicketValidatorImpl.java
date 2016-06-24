package com.walmart.ticket.service;

import com.walmart.ticket.common.entity.ClientError;
import com.walmart.ticket.exception.CustomValidationException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;

import java.util.Collections;
import java.util.List;

/**
 * Default implementation for {@link TicketValidator}
 */
public class TicketValidatorImpl implements TicketValidator {

	private static final Logger LOGGER = LogManager.getLogger(
		TicketValidatorImpl.class);

	private final MessageSource messageSource;

	public TicketValidatorImpl(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void throwExceptionIfLevelNotValid(final String venueLevel) {
		LOGGER.debug("Determining if input venue level '{}' is valid",
			venueLevel);
		final List<ClientError> clientErrors = buildErrorsIfVenueLevelNotValid(
			venueLevel);
		if (CollectionUtils.isNotEmpty(clientErrors)) {
			throw new CustomValidationException(clientErrors);
		}
		LOGGER.debug("Venue level '{}' is valid", venueLevel);
	}

	private List<ClientError> buildErrorsIfVenueLevelNotValid(
		final String venueLevel) {
		if (StringUtils.isAlphaSpace(venueLevel)) {
			return Collections.singletonList(
				new ClientError("Venue Level Id", "Venue should be numeric",
					"levelId"));
		}
		//TODO: validate for special symbols
		else if (Integer.valueOf(venueLevel) < 0) {
			return Collections.singletonList(new ClientError("Venue Level Id",
				"Venue level id should be a positive number", "levelId"));
		}
		else {
			return Collections.emptyList();
		}
	}
}
