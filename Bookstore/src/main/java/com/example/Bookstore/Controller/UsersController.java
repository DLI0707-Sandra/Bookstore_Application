package com.example.Bookstore.Controller;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Service.UsersService;
import com.example.Bookstore.Service.UsersServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/registration")
    public String registration(@RequestBody Users users){
       return usersService.registration(users);
    }

    @GetMapping("/login")
    public String login(@RequestBody UsersDto usersDto){
        return usersService.login(usersDto);
    }
}
