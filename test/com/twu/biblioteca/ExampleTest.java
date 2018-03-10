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
        assertEquals("[List Books]", app.getMenu());
    }

    @Test
    public void shouled_return_invalid_msg() {
        assertEquals("Select a valid option!", app.execute("err"));
    }
}
