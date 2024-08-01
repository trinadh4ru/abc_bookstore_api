# ABC_BOOKSTORE_API

This project is a simple library management system built using Quarkus. It provides RESTful endpoints to manage books and retrieve genres from a library. The application uses an in-memory database for ease of development and testing.

## Technologies Used

1. Quarkus: A Supersonic Subatomic Java Framework, designed to optimize Java for containers.
			To learn more about Quarkus, please visit its website: <https://quarkus.io/>.
			
2. Panache: A Quarkus library for simplifying JPA-based data access.
3. In-Memory H2 Database: A lightweight, in-memory database used for development and testing. No 						  configuration is required.
4. JBoss Logging: Integrated logging framework used for application logging and debugging.

## Endpoints Defined

1. Add New Book

	Endpoint: POST /api/books
	Description: Adds a new book to the library.
	Request Body:
	{
	  "title": "Book1",
	  "genre": "Action",
	  "author": "Author1",
	  "isbn": "ISBN001"
	}
	
2. Update Book Details

	Endpoint: PUT /api/books
	Description: Updates details of an existing book.
	Request Body:
	{
	  "id": 1,
	  "title": "Book1",
	  "genre": "Thriller",
	  "author": "Author2",
	  "isbn": "ISBN001"
	}

3. Get Genres

	Endpoint: GET /api/books/genres
	Description: Retrieves a list of unique genres available in the library.
	
4. Get Books by Genre

	Endpoint: GET /api/books?genre=Action
	Description: Retrieves a list of books filtered by genre.
		

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.
