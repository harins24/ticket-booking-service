package com.walmart.ticket.exception.handler;

import com.walmart.ticket.common.entity.ClientError;
import com.walmart.ticket.exception.CustomValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * This particular implementation is a convenient to handle
 * exceptions specific to this application.
 */
@ControllerAdvice
public class TicketExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(
		TicketExceptionHandler.class);

	private final MessageSource messageSource;

	public TicketExceptionHandler(final MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler({ CustomValidationException.class })
	public ResponseEntity<List<ClientError>> handleNotValidException(
		CustomValidationException exception) {
		HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
		CustomValidationException customValidationException = (CustomValidationException) exception;
		List<ClientError> errors = customValidationException.getClientErrors();
		LOGGER.error(
			"RequestNotValidException raised! Sending HTTP status \'{}\' along {}",
			responseStatus, errors);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<>(errors, headers, responseStatus);
	}
}
