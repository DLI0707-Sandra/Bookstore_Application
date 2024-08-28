package com.example.Bookstore.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="price")
    private Double price;

    @NotNull
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

//    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
//    private CartItem cartItem;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private WishlistItems wishlistItems;

    public Book(String name, String description, Double price, Integer stock, String author, String category, LocalDateTime created_at, LocalDateTime updated_at) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.author = author;
        this.category = category;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
