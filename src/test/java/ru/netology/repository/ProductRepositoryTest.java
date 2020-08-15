package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Таинственный остров", 500, "Жюль Верн");
    private Book second = new Book(2, "Властелин колец", 600, "Дж. Р. Р. Толкиен");

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);
        repository.save(second);
        int removeId = 2;
        repository.removeById(removeId);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }
}