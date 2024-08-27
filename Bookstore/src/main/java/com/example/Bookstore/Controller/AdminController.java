package com.example.Bookstore.Controller;
import com.example.Bookstore.DTO.AdminLoginDTO;
import com.example.Bookstore.Model.Admin;
import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Service.AdminService;
import com.example.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore_user/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private BookService bookService;


    @PostMapping("/add/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/update/book/{product_id}")
    public Book updateBook(@PathVariable Long product_id, @RequestBody Book book) {
        return bookService.updateBook(product_id, book);
    }

    @PostMapping("/delete/book/{product_id}")
    public String deleteBook(@PathVariable Long product_id) {

        return bookService.deleteBook(product_id);
    }


    @PostMapping("/registration")
    public Admin createAdmin(@RequestBody Admin admin) {

        return adminService.createAdmin(admin);
    }

    @PostMapping("/login")
    public String createAdmin(@RequestBody AdminLoginDTO admin) {
        return adminService.loginAdmin(admin);
    }
}


