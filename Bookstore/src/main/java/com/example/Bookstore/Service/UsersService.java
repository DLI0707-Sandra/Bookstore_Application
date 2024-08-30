package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    public String registration(Users users);

    String loginUser(UsersDto loginDTO);

}
