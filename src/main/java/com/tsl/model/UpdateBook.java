package com.tsl.model;

public class UpdateBook {
	
	private long id;
	private String title;
	private String genre;
	private String author;
	private String isbn;
	
	public UpdateBook() {}

    public UpdateBook(Long id, String title, String genre, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.isbn = isbn;
    }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
