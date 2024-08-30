package com.example.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id", "book_id"})}) // order_items table is created
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + (order != null ? order.getId() : "null") +
                ", bookId=" + (book != null ? book.getId() : "null") +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    } // return the order item details

}
