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
@Table(name = "wishlist_items",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cart_id", "book_id"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WishlistItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
        return "WishlistItems{" +
                "id=" + id +
                ", wishlistId=" + (wishlist != null ? wishlist.getId() : "null") +
                ", bookId=" + (book != null ? book.getId() : "null") +
                ", quantity=" + quantity +
                '}';
    }


}
