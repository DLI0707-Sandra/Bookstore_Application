package com.example.Bookstore.Service;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImplementation implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long productId, Book book) {
        Book old_book=bookRepository.findById(productId).orElse(null);
        if(old_book!=null)
        {
            old_book.setName(book.getName());
            old_book.setDescription(book.getDescription());
            old_book.setPrice(book.getPrice());
            old_book.setStock(book.getStock());
            old_book.setAuthor(book.getAuthor());
            old_book.setCategory(book.getCategory());
            old_book.setCreated_at(book.getCreated_at());
            old_book.setUpdated_at(book.getUpdated_at());
            bookRepository.save(old_book);
        }
        return old_book;
    }

    @Override
    public String deleteBook(Long productId) {
        Book book=bookRepository.findById(productId).orElse(null);
        if(book==null)
            return "Book not found!";
        else
        {
            bookRepository.deleteById(productId);
            return "Deleted!";
        }
    }

    @Override
    public List<Book> getByPriceLowtoHigh() {
        return
                bookRepository.displayLowtoHigh();
    }

    @Override
    public List<Book> getByPriceHightoLow() {
        return bookRepository.displayHightoLow();
    }

    @Override
    public List<Book> getByNewest() {
        return bookRepository.displayNewest();
    }
}
