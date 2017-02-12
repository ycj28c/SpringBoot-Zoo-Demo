package com.zoo.service.exception;

public class ZooAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ZooAlreadyExistsException(final String message) {
		super(message);
	}
}
