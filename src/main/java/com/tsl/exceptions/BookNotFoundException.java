package com.tsl.exceptions;

import jakarta.ws.rs.core.Response;

public class BookNotFoundException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
		super(message, Response.Status.NOT_FOUND);
    }
}
