package com.walmart.ticket.common.entity;

/**
 * Class that stores the path and the validation error message.
 */
public class InputError {

	private String path;

	private String message;

	public InputError(final String path, final String message) {
		this.path = path;
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public String getMessage() {
		return message;
	}
}
