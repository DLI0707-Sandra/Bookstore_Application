package com.example.Bookstore.Controller;

import com.example.Bookstore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore_user")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add/order")
    public void createOrder(@RequestBody Long userId)
    {
        orderService.createOrder(userId);
    }
}