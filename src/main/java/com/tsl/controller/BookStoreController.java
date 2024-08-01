package com.tsl.controller;

import java.util.List;

import com.tsl.model.AddBook;
import com.tsl.model.Book;
import com.tsl.model.UpdateBook;
import com.tsl.service.BookStoreService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookStoreController {
	
	@Inject
	BookStoreService bookStoreService;
	
	@POST
	public Response addBook(AddBook request) {
		Book book = bookStoreService.addBook(request);
        return Response.status(Response.Status.OK).entity(book).build();
    }

    @PUT
    public Response updateBook(UpdateBook request) {
        Book book = bookStoreService.updateBook(request);
        return Response.ok(book).build();
    }

    @GET
    @Path("/genres")
    public Response getGenres() {
        List<String> genres = bookStoreService.getGenres();
        return Response.ok(genres).build();
    }

    @GET
    public Response getBooksByGenre(@QueryParam("genre") String genre) {
        List<Book> books = bookStoreService.getBooksByGenres(genre);
        return Response.ok(books).build();
    }

}
