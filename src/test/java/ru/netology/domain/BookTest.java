package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Таинственный остров", 500, "Жюль Верн");

    @Test
    public void shouldMatchByNameIfExists() {
        String text = "Таинственный остров";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldMatchByNameIfNotExists() {
        String text = "Властелин колец";
        assertFalse(book.matches(text));
    }

    @Test
    public void shouldMatchByAuthorIfExists() {
        String text = "Жюль Верн";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldMatchByAuthorIfNotExists() {
        String text = "Дж. Р. Р. Толкиен";
        assertFalse(book.matches(text));
    }
}