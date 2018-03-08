package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
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
}
