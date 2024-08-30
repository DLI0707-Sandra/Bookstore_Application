package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    // OrderRepository interface extends JpaRepository with Order and Long as parameters
}
