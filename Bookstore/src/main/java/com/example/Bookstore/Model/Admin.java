package com.example.Bookstore.Model;
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
@Table(name = "admin")
public class Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @Column(name="username", unique=true)
        private String username;

        @NotNull
        @Column(name="email", unique=true)
        private String email;

        @NotNull
        @Column(name="password")
        private String password;

        @Column(name = "created_at")
        private LocalDateTime created_at;
    }

