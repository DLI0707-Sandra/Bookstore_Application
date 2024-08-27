package com.example.Bookstore.DTO;

import com.example.Bookstore.Model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersDetailsDto {
    private String customerName;
    private String email;
    private String address;
    private String phoneNo;
    private Long user_id;
}
