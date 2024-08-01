package com.tsl.exceptions;

import jakarta.ws.rs.core.Response;

public class InvalidBookException extends CustomException {
	private static final long serialVersionUID = 1L;

	public InvalidBookException(String message) {
		super(message, Response.Status.BAD_REQUEST);
    }
}
