package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Cart;
import com.example.Bookstore.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    @Query("SELECT w FROM Wishlist w WHERE w.users.id = :userId")
    Optional<Wishlist> findByUserId(@Param("userId") Long userId);
}
