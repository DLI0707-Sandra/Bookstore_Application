package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Exception.UserNotFoundException;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.UsersRepo;
import com.example.Bookstore.util.TokenUtillity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImplementation implements UsersService{
   @Autowired
    UsersRepo usersRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenUtillity tokenUtillity;

    @Override
    public String registration(Users users) {
      Users newUSer=new Users();
      newUSer.setUserId(users.getUserId());
      newUSer.setUserName(users.getUserName());
      newUSer.setEmail(users.getEmail());
      newUSer.setPassword(passwordEncoder.encode(users.getPassword()));
     newUSer.setCreated_at(LocalDateTime.now());
    usersRepo.save(newUSer);
        return "User added";
    }


    public String loginUser(UsersDto loginDTO) {
        Users  user =  usersRepo.findByUserName( loginDTO.getUserName());
        if(user==null)
            throw new UserNotFoundException("Invalid credentials");

        if (passwordEncoder.matches( loginDTO.getPassword(),  user.getPassword())) {
            return  tokenUtillity.generateToken( user.getUserName());
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
   }

    public List<Users> allUser() {
        return usersRepo.findAll();
    }

    public boolean verifyToken(String token) {
        String username = tokenUtillity.extractUsername(token);
        Users user = usersRepo.findByUserName(username);

        if (user!=null) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
            return tokenUtillity.validateToken(token, userDetails);
        }
        return false;
    }
}
