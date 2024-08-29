package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAll();
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
