package com.example.Bookstore.Controller;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Service.UsersService;
import com.example.Bookstore.Service.UsersServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bookstore_user")
public class UsersController {

    @Autowired
    UsersServiceImplementation usersService;
    @GetMapping("/allusers")
    public List<Users> allUser(){
        return usersService.allUser();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UsersDto  loginDTO){
        String token= usersService.loginUser(loginDTO);
        return ResponseEntity.ok(Collections.singletonMap("token",token));
    }

    @PostMapping("/verification/{token}")
    public ResponseEntity<?> userVerification(@PathVariable String token) {
        boolean isVerified = usersService.verifyToken(token);
        if (isVerified) {
            return ResponseEntity.ok("User account verified successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token.");
        }
    }

    @PostMapping("/registration")
    public String registration(@Valid @RequestBody Users users){
       return usersService.registration(users);
    }

}
