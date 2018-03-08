package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> allBooks = new ArrayList<Book>();

    public BibliotecaApp() {
        allBooks.add(new Book("math"));
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public ArrayList<Book> findBooks() {
        return allBooks;
    }
}


class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }
}