package com.tsl.model;

public class AddBook {
	
	private String title;
	private String genre;
	private String author;
	private String isbn;
	
	public AddBook() {}

    public AddBook(String title, String genre, String author, String isbn) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isbn = isbn;
    }
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
