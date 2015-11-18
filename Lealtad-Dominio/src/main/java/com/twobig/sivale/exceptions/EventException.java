package com.twobig.sivale.exceptions;

public class EventException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -913022201108462435L;

	public EventException() {
	}

	public EventException(String message) {
		super(message);
	}

	public EventException(Throwable cause) {
		super(cause);
	}

	public EventException(String message, Throwable cause) {
		super(message, cause);
	}

}
