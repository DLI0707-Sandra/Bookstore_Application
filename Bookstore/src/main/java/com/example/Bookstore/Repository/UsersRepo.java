package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepo extends JpaRepository<Users,Long> {
    public Users findByUserName(String userName);
}
