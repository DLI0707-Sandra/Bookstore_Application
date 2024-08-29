package com.example.Bookstore.Controller;

import com.example.Bookstore.Repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore_user")
@Slf4j
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UsersRepo usersRepo;
}
