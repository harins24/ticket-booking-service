package com.walmart.ticket.exception;

import com.walmart.ticket.common.entity.ClientError;

import java.util.List;

/**
 * {@link RuntimeException} used for validation clientErrors
 */
public class CustomValidationException extends RuntimeException {

	private List<ClientError> clientErrors;

	public CustomValidationException(final String message) {
		super(message);
	}

	public CustomValidationException(final String message,
		final Throwable cause) {
		super(message, cause);
	}

	public CustomValidationException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new Not valid exception with the List of error messages with
	 * error cause
	 */
	public CustomValidationException(final List<ClientError> clientErrors,
		final Throwable cause) {
		super(cause);
	}

	public CustomValidationException(final List<ClientError> clientErrors) {
		this.clientErrors = clientErrors;
	}

	public List<ClientError> getClientErrors() {
		return clientErrors;
	}
}
