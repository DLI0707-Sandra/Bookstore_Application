package com.example.Bookstore.Controller;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Service.UsersService;
import com.example.Bookstore.Service.UsersServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersServiceImplementation usersService;

    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UsersDto loginDTO){
        try{
          //  System.out.println("user available");
            return ResponseEntity.ok( usersService.loginUser(loginDTO));

        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or Password");
        }
    }

    @GetMapping
    public Users getBytoken(@RequestHeader String token){
        return usersService.getByToken(token);
    }

    @PostMapping("/registration")
    public String registration(@RequestBody Users users){
       return usersService.registration(users);
    }

//    @GetMapping("/login")
//    public String login(@RequestBody UsersDto usersDto){
//        return usersService.login(usersDto);
//    }
}
