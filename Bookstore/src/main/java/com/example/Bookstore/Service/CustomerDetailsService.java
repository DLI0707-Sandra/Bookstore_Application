package com.example.Bookstore.Service;

import com.example.Bookstore.Model.CustomerDetails;

import java.util.List;

public interface CustomerDetailsService {
    public String addCustomer(CustomerDetails customerDetails);
    public String updateCustomerById(Long id,CustomerDetails customerDetails);
    public List<CustomerDetails> readAll();

    String deletebyId(Long id);
}
