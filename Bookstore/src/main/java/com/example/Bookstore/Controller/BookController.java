package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bookstore_user")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAll();
    }

    @GetMapping("get/books/low_to_high")
    public List<Book> getByPriceLowtoHigh()
    {
        return bookService.getByPriceLowtoHigh();
    }

    @GetMapping("get/books/high_to_low")
    public List<Book> getByPriceHightoLow()
    {
        return bookService.getByPriceHightoLow();
    }

    @GetMapping("get/books/newest")
    public List<Book> getByNewest()
    {
        return bookService.getByNewest();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

    @PutMapping
    public Book updateBook(Long product_id,Book book)
    {
        return bookService.updateBook(product_id,book);
    }

    @DeleteMapping
    public String deleteBook(Long product_id)
    {
        return bookService.deleteBook(product_id);
    }

}
