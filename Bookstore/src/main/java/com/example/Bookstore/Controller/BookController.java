package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }
}
