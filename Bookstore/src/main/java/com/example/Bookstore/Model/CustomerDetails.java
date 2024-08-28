package com.example.Bookstore.Model;

import com.example.Bookstore.DTO.UsersDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customerDetail")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @NotNull
    @Column(name="customerName")
    private String customerName;

    @Column(name="email")
    private String email;


    @Column(name="address")
    private String address;

    @Column(name = "phoneNo")
    private String phoneNo;

    @OneToOne
    @JoinColumn(name = "userId")
    private Users users;
}
