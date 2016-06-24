package com.walmart.ticket.common.entity;

import java.math.BigDecimal;

/**
 * Entity that holds data related to a venue
 */
public class Venue {

	private int levelId;

	private String levelName;

	private BigDecimal price;

	private int rows;

	private int seatsInRow;

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(final int levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(final String levelName) {
		this.levelName = levelName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(final int rows) {
		this.rows = rows;
	}

	public int getSeatsInRow() {
		return seatsInRow;
	}

	public void setSeatsInRow(final int seatsInRow) {
		this.seatsInRow = seatsInRow;
	}

	@Override
	public String toString() {
		return "Venue{" +
			"levelId='" + levelId +
			"', levelName='" + levelName +
			"', price=" + price +
			"', rows=" + rows +
			"', seatsInRow=" + seatsInRow +
			"'}";
	}
}
