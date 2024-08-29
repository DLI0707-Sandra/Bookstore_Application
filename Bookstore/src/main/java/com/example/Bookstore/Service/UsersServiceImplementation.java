package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.UsersDto;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.UsersRepo;
import com.example.Bookstore.util.TokenUtillity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImplementation implements UsersService{
   @Autowired
    UsersRepo usersRepo;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    TokenUtillity tokenUtillity;

    @Override
    public String registration(Users users) {
      Users newUSer=new Users();
      newUSer.setUserId(users.getUserId());
      newUSer.setUserName(users.getUserName());
      newUSer.setEmail(users.getEmail());
    //  newUSer.setPassword(passwordEncoder.encode(users.getPassword()));
        newUSer.setPassword(users.getPassword());
     newUSer.setCreated_at(LocalDateTime.now());
    usersRepo.save(newUSer);
        return "User added";
    }

    @Override
    public String login(UsersDto usersDto) {
        System.out.println("hello hello");
      Users result= usersRepo.findByUserName(usersDto.getUserName());
      if(result!=null){
         // if(passwordEncoder.matches(result.getPassword(),usersDto.getPassword())){
          if(result.getPassword().equals(usersDto.getPassword())){
              return "User login";
          }
          else
              return "incorrect password";
      }else
          return "User not present";
    }

    public ResponseEntity<?> loginUser(UsersDto loginDTO) {
        Users users = usersRepo.findByUserName(loginDTO.getUserName());
        System.out.println("loggg\n\n");
        //if(users!=null && passwordEncoder.matches(users.getPassword(),loginDTO.getPassword())){
        if(users!=null && users.getPassword().equals(loginDTO.getPassword())){
            String token = tokenUtillity.createToken(users.getUserId());

            Map<String, Object> response = new HashMap<>();
            response.put("message","Login Successful");
            response.put("token",token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new RuntimeException("Login Failed");
        }
   }

    public Users getUsersById(Long id) {
        return usersRepo.findById(id).orElseThrow();
    }

    public Users getByToken(String token) {
        Long id = tokenUtillity.decodeToken(token);
        return getUsersById(id);
    }

    public List<Users> allUser() {
        return usersRepo.findAll();
    }
}
