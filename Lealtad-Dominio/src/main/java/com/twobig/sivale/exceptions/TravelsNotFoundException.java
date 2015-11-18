package com.twobig.sivale.exceptions;

public class TravelsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -563690520573151209L;

	public TravelsNotFoundException() {
	}

	public TravelsNotFoundException(String message) {
		super(message);
	}

	public TravelsNotFoundException(Throwable cause) {
		super(cause);
	}

	public TravelsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
