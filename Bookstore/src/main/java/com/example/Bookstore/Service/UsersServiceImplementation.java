package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImplementation implements UsersService{
   @Autowired
    UsersRepo usersRepo;

    @Override
    public String registration(Users users) {
        usersRepo.save(users);
        return "User added";
    }

    @Override
    public String login(UsersDto usersDto) {
      Users result= usersRepo.findByUserName(usersDto.getUserName());
      if(result!=null){
          if(result.getPassword().equals(usersDto.getPassword())){
              return "User login";
          }
          else
              return "incorrect password";
      }else
          return "User not present";
    }
}
