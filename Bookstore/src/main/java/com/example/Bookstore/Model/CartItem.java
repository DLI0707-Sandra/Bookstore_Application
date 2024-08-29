package com.example.Bookstore.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_items",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cart_id", "book_id"})
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cartId=" + (cart != null ? cart.getId() : "null") +
                ", bookId=" + (book != null ? book.getId() : "null") +
                ", quantity=" + quantity +
                '}';
    }

}
