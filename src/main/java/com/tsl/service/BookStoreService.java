package com.tsl.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.h2.util.StringUtils;
import org.jboss.logging.Logger;

import com.tsl.exceptions.BookNotFoundException;
import com.tsl.exceptions.InvalidBookException;
import com.tsl.model.AddBook;
import com.tsl.model.Book;
import com.tsl.model.UpdateBook;
import com.tsl.repository.DBRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookStoreService {

	private static final Logger LOGGER = Logger.getLogger(BookStoreService.class);

	@Inject
	DBRepository dbRepository;

	@Transactional
	public Book addBook(AddBook request) {
		validateRequest(request);
		Book book = new Book(request.getTitle(), request.getGenre(), request.getAuthor(), request.getIsbn());
		dbRepository.persist(book);
		LOGGER.info("Added new book: " + book.getTitle());
		return book;
	}

	@Transactional
	public Book updateBook(UpdateBook request) {
		Book book = dbRepository.findById(request.getId());
		if (null == book) {
			LOGGER.error("Book with ID " + request.getId() + " not found");
			throw new BookNotFoundException("Book ID " + request.getId() + " not found");
		}
		book.setTitle(request.getTitle());
		book.setGenre(request.getGenre());
		book.setAuthor(request.getAuthor());
		book.setIsbn(request.getIsbn());
		LOGGER.info("Updated book: " + book.getTitle());
		return book;
	}

	public List<String> getGenres() {
		List<Book> booksList = dbRepository.findAll().list();
		Set<String> genreSet = new HashSet<>();
		for (Book book : booksList) {
			genreSet.add(book.getGenre());
		}
		LOGGER.debug("Retrieved genres: " + genreSet);
		return new ArrayList<>(genreSet);
	}

	public List<Book> getBooksByGenres(String genre) {
		if (genre == null || genre.isEmpty()) {
			LOGGER.warn("Invalid genre parameter: " + genre);
			throw new InvalidBookException("Genre cannot be empty or null");
		}
		List<Book> books = dbRepository.find("genre", genre).list();
		LOGGER.info("Retrieved " + books.size() + " books for genre: " + genre);
		return books;
	}

	private void validateRequest(AddBook request) {
		if (StringUtils.isNullOrEmpty(request.getTitle())) {
			LOGGER.error("Invalid title: " + request.getTitle());
			throw new InvalidBookException("Title cannot be null or empty");
		}
		if (StringUtils.isNullOrEmpty(request.getGenre())) {
			LOGGER.error("Invalid genre: " + request.getGenre());
			throw new InvalidBookException("Genre cannot be null or empty");
		}
		if (StringUtils.isNullOrEmpty(request.getAuthor())) {
			LOGGER.error("Invalid author: " + request.getAuthor());
			throw new InvalidBookException("Author cannot be null or empty");
		}
		if (StringUtils.isNullOrEmpty(request.getIsbn())) {
			LOGGER.error("Invalid ISBN: " + request.getIsbn());
			throw new InvalidBookException("ISBN cannot be null or empty");
		}
	}
}
