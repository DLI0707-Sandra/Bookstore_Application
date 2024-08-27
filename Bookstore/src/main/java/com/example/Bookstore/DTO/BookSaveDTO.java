package com.example.Bookstore.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDTO {

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String author;

    private String category;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
