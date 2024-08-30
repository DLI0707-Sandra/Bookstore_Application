package com.example.Bookstore.Controller;

import com.example.Bookstore.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore_user")
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;// OrderItemRepository object is created and autowired

    @Autowired
    BookRepository bookRepository;// BookRepository object is created and autowired

    @Autowired
    OrderRepository orderRepository;// OrderRepository object is created and autowired

    @Autowired
    UsersRepo usersRepo;// UsersRepo object is created and autowired
}
