package com.multiplex.exception;

public class BookingAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingAlreadyExistException(String message) {
		super(message);
	}

}
