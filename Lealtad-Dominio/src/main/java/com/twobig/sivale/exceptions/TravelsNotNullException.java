package com.twobig.sivale.exceptions;

public class TravelsNotNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -563690520573151209L;

	public TravelsNotNullException() {
	}

	public TravelsNotNullException(String message) {
		super(message);
	}

	public TravelsNotNullException(Throwable cause) {
		super(cause);
	}

	public TravelsNotNullException(String message, Throwable cause) {
		super(message, cause);
	}

}
