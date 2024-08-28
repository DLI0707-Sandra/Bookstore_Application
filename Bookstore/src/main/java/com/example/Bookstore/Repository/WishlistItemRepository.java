package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WishlistItemRepository extends JpaRepository<WishlistItems,Long> {
}
