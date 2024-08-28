package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Cart;
import com.example.Bookstore.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query("SELECT c FROM Cart c WHERE c.users.id = :userId")
    Optional<Cart> findByUserId(@Param("userId") Long userId);

}
