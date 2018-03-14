package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExampleTest {
    BibliotecaApp app;

    @Before
    public void resetApp () {
        app = new BibliotecaApp();
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testReset() {
        assertNotNull(app);
    }

    @Test
    public void should_return_books() {
        assertTrue(app.findBooks().size() > 0);
    }

    @Test
    public void should_return_book_detail() {
        assertEquals("Gauss", app.findBooks().get(0).getAuthor());
        assertEquals(new Date(1990, 10, 10), app.findBooks().get(0).getPublishDate());
    }

    @Test
    public void should_return_main_menu() {
        assertTrue( app.getMenu().contains("List Books"));
    }

    @Test
    public void should_return_invalid_msg() {
        assertEquals("Select a valid option!", app.execute("err"));
    }

    @Test
    public void should_quit_app() {

    }

    @Test
    public void should_checkout() {
        assertEquals(app.checkout("math"), "Thank you! Enjoy the book");
    }

    @Test
    public void should_checkout_fail() {
        assertEquals(app.checkout("TDD"), "That book is not available.");
    }

    @Test
    public void should_return_book() {
        assertEquals(app.returnBook("math"), "Thank you for returning the book.");
    }

    @Test
    public void should_return_book_fail() {
        assertEquals(app.returnBook("TDD"), "That is not a valid book to return.");
    }
}
