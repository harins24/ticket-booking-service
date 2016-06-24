package com.walmart.ticket.common.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Class that represents error for an input
 */
public class ClientError {

	private String title;

	private String message;

	private String path;

	public ClientError(final String title, final String message,
		final String path) {
		super();
		this.title = title;
		this.message = message;
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(title).append(message).append(
			path).toHashCode();
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}
		else if (object instanceof ClientError) {
			final ClientError other = (ClientError) object;
			return new EqualsBuilder().append(title, other.getTitle()).append(
				message, other.getMessage()).append(path,
				other.getPath()).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return "ClientError [title=" + title + ", Message=" + message
			+ ", path=" + path + "]";
	}
}
