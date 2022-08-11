package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first  = new Book(1, "Книга 1", 1000, "Автор 1");
    private Book second  = new Book(2, "Книга 2", 2000, "Автор 1");
    private Smartphone third  = new Smartphone(3, "Смартфон 1", 10_000, "Производитель 1");
    private Smartphone fourth  = new Smartphone(4, "Смартфон 2", 20_000, "Производитель 1");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }
    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{first, second, third, fourth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Книга 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Смартфон 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName2() {
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Смартфон 2");
        assertArrayEquals(expected, actual);
    }


}

