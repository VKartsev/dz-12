package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Книга 1", 1000, "Автор 1");
    private Book second = new Book(2, "Книга 2", 2000, "Автор 1");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
    }

    @Test
    public void shouldRemoveByID() {
        Product[] expected = new Product[]{second};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
