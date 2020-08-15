package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product(1, "Таинственный остров", 500);

    @Test
    void shouldMatchByNameIfExists() {
        String text = "Таинственный остров";
        assertTrue(product.matches(text));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String text = "Властелин колец";
        assertFalse(product.matches(text));
    }
}