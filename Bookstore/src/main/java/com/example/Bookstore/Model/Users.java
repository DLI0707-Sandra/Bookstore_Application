package com.example.Bookstore.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Column(name="userName")
    private String userName;

    @Pattern(regexp = "^[A-Za-z0-9_]+@[A-Za-z]+\\.[A-Za-z]{2,}$", message = "Invalid email address")
    @Column(name="email")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password length should be greater than 6!")
    @Column(name="password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @OneToOne(mappedBy = "users")
    private CustomerDetails customerDetails;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Wishlist wishlist;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", customerDetails=" + (customerDetails != null ? customerDetails.getCustomerId() : "null") +
                ", cartId=" + (cart != null ? cart.getId() : "null") +
                ", wishlistId=" + (wishlist != null ? wishlist.getId() : "null") +
                ", feedbackList=" + feedbackList +
                '}';
    }

}
