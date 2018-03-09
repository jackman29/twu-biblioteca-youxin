package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BibliotecaApp {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private MenuItem[] menu = new MenuItem[]{MenuItem.LIST_BOOKS};
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
}

enum MenuItem {
    LIST_BOOKS("List Books"),;

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
}