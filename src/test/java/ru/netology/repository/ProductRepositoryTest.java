package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Таинственный остров", 500, "Жюль Верн");
    private Book second = new Book(2, "Властелин колец", 600, "Дж. Р. Р. Толкиен");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
    }

    @Test
    public void shouldRemoveIfExists() {
        int removeId = 2;
        repository.removeById(removeId);
        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullIfNotExists() {
        int removeId = 4;
        repository.findById(removeId);
        Product expected = null;
        Product actual = repository.findById(removeId);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdIfNotExist() {
        int requestedId = 4;
        assertThrows(NotFoundException.class, () -> repository.removeById(requestedId));
    }
}