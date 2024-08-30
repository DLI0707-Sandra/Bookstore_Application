package com.example.Bookstore.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "admin")
public class Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @Column(name="username", unique=true)
        @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$", message = "Username must be alphanumeric")
        private String username;

        @NotNull
        @Column(name="email", unique=true)
        private String email;

        @NotNull
        @Column(name="password")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password must be 8-20 characters long, contain at least one digit, one letter, and one special character")
        private String password;

        @Column(name = "created_at")
        private LocalDateTime created_at;


//        @NotNull
//        @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$", message = "Username must be alpha
//
//
//        @NotNull
//        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Password must be 8-20 characters long, contain at least one digit, one letter, and one special character")
//        @Column(name="password")
//
    }

