package com.example.Bookstore.Repository;

import com.example.Bookstore.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Long> {
}
