package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;

public interface UsersService {
    public String registration(Users users);
    public String login(UsersDto usersDto);
}
