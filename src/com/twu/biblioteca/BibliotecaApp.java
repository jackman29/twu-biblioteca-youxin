package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BibliotecaApp {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private MenuItem[] menu = new MenuItem[]{MenuItem.LIST_BOOKS, MenuItem.QUIT};
    public BibliotecaApp() {
        allBooks.add(new Book("math", "Gauss", new Date(1990, 10, 10)));
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
        int cmdCount = menu.length;
        String msg = "Select a valid option!";
        for (int i = 0; i < cmdCount; i++) {
            if (menu[i].toString().equals(cmd)) {
                msg = "OK";
                if (i == 1){
                    System.exit(0);
                }
            }
        }
        return msg;
    }

    public String checkout(String bookName) {
        boolean available = allBooks.contains(new Book(bookName));
        if (available) {
            return "Thank you! Enjoy the book";
        }
        return "That book is not available.";
    }
}

enum MenuItem {
    LIST_BOOKS("List Books"),QUIT("QUIT");

    private String name;

    MenuItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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