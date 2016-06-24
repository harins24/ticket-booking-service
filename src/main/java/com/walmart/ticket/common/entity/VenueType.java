package com.walmart.ticket.common.entity;

/**
 * Created by xprk029 on 6/24/2016.
 */
public enum VenueType {
	ORCHESTRA("", 1),
	MAIN("Main", 2),
	BALCONY_1("Balcony 1", 3),
	BALCONY_2("Balcony 2", 4);

	private final String value;

	private final int level;

	VenueType(final String value, final int level) {
		this.value = value;
		this.level = level;
	}

	public String getValue() {
		return value;
	}

	public int getLevel() {
		return level;
	}

	public static String getValue(final int level) {
		final VenueType[] venueTypes = VenueType.values();
		for (VenueType venueType : venueTypes) {
			if (venueType.level == level) {
				return venueType.value;
			}
		}
		return null;
	}
}
