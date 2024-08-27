package com.example.Bookstore.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Column(name="userName")
    private String userName;

    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Wishlist wishlist;
}
