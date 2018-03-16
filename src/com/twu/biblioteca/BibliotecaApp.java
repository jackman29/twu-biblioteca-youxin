package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BibliotecaApp {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private ArrayList<Movie> allMovies = new ArrayList<Movie>();
    private ArrayList<Book> allBooksCopy;
    private MenuItem[] menu = new MenuItem[]{MenuItem.LIST_BOOKS, MenuItem.QUIT};

    public BibliotecaApp() {
        allBooks.add(new Book("math", "Gauss", new Date(1990, 10, 10)));
        allMovies.add(new Movie("Star Wars"));
        allBooksCopy = new ArrayList<Book>(allBooks);
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public ArrayList<Book> findBooks() {
        return allBooks;
    }

    public String getMenu() {
        return Arrays.toString(menu);
    }

    public String execute(String cmd) {
        String msg = "";
        MenuItem cmdItem;
        try {
            cmdItem = MenuItem.valueOf(cmd);
        } catch (Exception e) {
            return "Select a valid option!";
        }
        switch (cmdItem) {
            case LIST_BOOKS:
                msg = "OK";
                break;
            case QUIT:
                System.exit(0);
                break;
            default:
                msg = "Select a valid option!";

        }
        return msg;
    }

    public String checkout(String bookName) {
        Book book = new Book(bookName);
        boolean available = allBooks.contains(book);
        if (available) {
            allBooks.remove(book);
            return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }

    public String returnBook(String bookName) {
        Book book = new Book(bookName);
        int valid = allBooksCopy.indexOf(book);
        if (valid != -1) {
            allBooks.add(allBooksCopy.get(valid));
            return "Thank you for returning the book.";
        }
        return "That is not a valid book to return.";
    }

    public String listMovies() {
        String movies = "";
        for (Movie movie:  allMovies
             ) {
            movies = movies.concat(movie.toString());
        }
        return (movies);
    }
}

enum MenuItem {
    LIST_BOOKS("List Books"),
    CHECK_OUT("Check Out"),
    RETURN("Return"),
    QUIT("QUIT");

    private String name;

    MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


class Movie {
    String name;

    public Movie(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Book {
    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    private Date publishDate;

    public Book(String name, String author, Date publishDate) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return this.name.equals(((Book) obj).getName());
        }
        return false;
    }
}