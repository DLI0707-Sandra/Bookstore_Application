package com.example.Bookstore.Service;

import com.example.Bookstore.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book addBook(Book book);

    Book updateBook(Long productId, Book book);

    String deleteBook(Long productId);

    List<Book> getByPriceLowtoHigh();

    List<Book> getByPriceHightoLow();

    List<Book> getByNewest();
}
