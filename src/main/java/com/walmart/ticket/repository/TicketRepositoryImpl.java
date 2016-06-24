package com.walmart.ticket.repository;

import com.walmart.ticket.common.entity.Venue;
import com.walmart.ticket.exception.TicketException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation for {@link TicketRepository}
 */
public class TicketRepositoryImpl extends NamedParameterJdbcDaoSupport
	implements TicketRepository {

	private static final Logger LOGGER = LogManager.getLogger(
		TicketRepositoryImpl.class);

	private final String queryNumberOfSeatsByLevel;

	public TicketRepositoryImpl(final String queryNumberOfSeatsByLevel) {
		this.queryNumberOfSeatsByLevel = queryNumberOfSeatsByLevel;
	}

	@Override
	public Venue findOne(final Integer venueLevel) {
		LOGGER.debug("Finding venue details for input venue level {}",
			venueLevel);
		final Map<String, Object> params = new HashMap<>(1);
		params.put("venueLevel", venueLevel);
		try {
			final Venue venue = getNamedParameterJdbcTemplate().query(
				queryNumberOfSeatsByLevel, params, new VenueExtractor());
			LOGGER.debug("Venue details for input level {} are {}", venueLevel,
				venue);
			return venue;
		}
		catch (DataAccessException e) {
			throw new TicketException(
				"Unable to retrieve venue details for the level " + venueLevel,
				e);
		}
	}
}
