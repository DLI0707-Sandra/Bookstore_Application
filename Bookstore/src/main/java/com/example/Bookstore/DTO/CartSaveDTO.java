package com.example.Bookstore.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartSaveDTO {
    private Long user_id;
    private LocalDateTime created_at;
}
