package com.example.Bookstore.Controller;
import com.example.Bookstore.DTO.AdminLoginDTO;
import com.example.Bookstore.Model.Admin;
import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.Order;
import com.example.Bookstore.Repository.OrderRepository;
import com.example.Bookstore.Service.AdminService;
import com.example.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @Autowired
    private BookService bookService;


    @Autowired
    OrderRepository orderRepository;



    @PostMapping("/registration")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PostMapping("/login")
    public String createAdmin(@RequestBody AdminLoginDTO admin) {
        return adminService.loginAdmin(admin);
    }


    @PostMapping(value = "/add/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update/book/{bookId}")
    public Book updateBook(@PathVariable("bookId")Long product_id, @RequestBody Book book) {
        return bookService.updateBook(product_id, book);
    }

    @DeleteMapping("/delete/book/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long product_id) {

        return bookService.deleteBook(product_id);
    }

    @GetMapping("/get/order")
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }

}


