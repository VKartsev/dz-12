package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        Product[] expected = {first, second, third, fourth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {
        Product[] expected = {first};
        Product[] actual = manager.searchBy("Книга 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] expected = {third};
        Product[] actual = manager.searchBy("Смартфон 1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName2() {
        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Смартфон 2");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSeveralBooks() {
        Product[] expected = {first, second};
        Product[] actual = manager.searchBy("Книга");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralSmartphones() {
        Product[] expected = {third, fourth};
        Product[] actual = manager.searchBy("Смартфон");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindNothing() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга 3");
        assertArrayEquals(expected, actual);
    }

}

