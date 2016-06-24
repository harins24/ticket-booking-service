package com.walmart.ticket.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Validation error object that stores list of {@link InputError}
 */
public class ValidationError {

	private List<InputError> inputErrors = new ArrayList<>();

	public ValidationError() {
	}

	public void addFieldError(String path, String message) {
		InputError error = new InputError(path, message);
		inputErrors.add(error);
	}

	public List<InputError> getInputErrors() {
		return inputErrors;
	}
}
