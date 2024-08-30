package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    // OrderItemRepository interface extends JpaRepository with OrderItem and Long as parameters
}
