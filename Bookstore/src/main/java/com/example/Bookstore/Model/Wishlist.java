package com.example.Bookstore.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="wishlist_item")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "wishlist")
    private List<WishlistItems> wishlists;

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", userId=" + (users != null ? users.getUserId() : "null") +
                ", created_at=" + created_at +
                ", wishlists=" + wishlists +
                '}';
    }

}



