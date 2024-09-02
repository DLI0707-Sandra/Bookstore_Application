package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    CartItem findByCartIdAndBookId(Long id, Long id1);

    List<CartItem> findByCartId(Long cartId);
}
