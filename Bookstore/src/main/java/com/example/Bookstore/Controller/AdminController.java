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
import java.util.Objects;

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
    public ResponseEntity<Object> createAdmin(@RequestBody Admin admin) {
        adminService.createAdmin(admin);
        return new ResponseEntity<>("Admin is registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String createAdmin(@RequestBody AdminLoginDTO admin) {
        return adminService.loginAdmin(admin);
    }


    @PostMapping(value = "/add/book")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/book/{bookId}")
    public ResponseEntity<Object> updateBook(@PathVariable("bookId")Long product_id, @RequestBody Book book) {
        bookService.updateBook(product_id, book);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/book/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long product_id) {

        bookService.deleteBook(product_id);
        return "Deleted Successfully";
    }

    @GetMapping("/get/order")
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }

}


