package com.walmart.ticket.repository;

import com.walmart.ticket.common.entity.Venue;
import com.walmart.ticket.repository.entity.TicketTableColumn;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * {@link ResultSetExtractor} that extracts venue details from {@link ResultSet}
 */
public class VenueExtractor implements ResultSetExtractor<Venue> {

	@Override
	public Venue extractData(final ResultSet rs)
		throws SQLException, DataAccessException {
		Venue venue = null;
		if (rs.isBeforeFirst()) {
			while (rs.next()) {
				venue = new Venue();
				venue.setLevelId(rs.getInt(TicketTableColumn.LEVEL_ID.name()));
				venue.setLevelName(
					rs.getString(TicketTableColumn.LEVEL_NAME.name()));
				venue.setRows(
					rs.getInt(TicketTableColumn.NUMBER_OF_ROWS.name()));
				venue.setSeatsInRow(
					rs.getInt(TicketTableColumn.SEATS_IN_ROW.name()));
			}
		}
		return venue;
	}
}
