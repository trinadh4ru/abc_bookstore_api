package com.tsl.exceptions;

import jakarta.ws.rs.core.Response;

public class CustomException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Response.Status status;

    public CustomException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
