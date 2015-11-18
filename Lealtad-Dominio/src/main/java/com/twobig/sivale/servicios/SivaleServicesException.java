/**
 * 
 */
package com.twobig.sivale.servicios;



public class SivaleServicesException extends Exception {

	private static final long serialVersionUID = 741878673379646076L;

	public SivaleServicesException(Exception cause) {
		super(cause);
	}

	public SivaleServicesException(String message, Exception cause) {
		super(message, cause);
	}

	public SivaleServicesException(String message, Throwable cause) {
		super(message, cause);
	}

}
