package com.tsl.mappers;

import com.tsl.exceptions.CustomException;
import com.tsl.model.ErrorResponse;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), "Error occurred");
        return Response.status(exception.getStatus())
                .entity(errorResponse)
                .build();
    }
}
