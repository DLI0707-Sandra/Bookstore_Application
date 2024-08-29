package com.example.Bookstore.Service;

import com.example.Bookstore.Model.CustomerDetails;
import com.example.Bookstore.Repository.CustomerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImplementation implements CustomerDetailsService {

    @Autowired
    CustomerDetailsRepo customerDetailsRepo;


    @Override
    public String addCustomer(CustomerDetails customerDetails) {
        customerDetailsRepo.save(customerDetails);
        return "customer added";
    }


    @Override
    public String updateCustomerById(Long id,CustomerDetails customerDetails) {
        if(id>0) {
            CustomerDetails results = customerDetailsRepo.findById(id).orElseThrow();
            results.setCustomerName(customerDetails.getCustomerName());
            results.setCustomerId(customerDetails.getCustomerId());
            results.setEmail(customerDetails.getEmail());

            results.setPhoneNo(customerDetails.getPhoneNo());
            results.setAddress(customerDetails.getAddress());
            customerDetailsRepo.deleteById(id);
            customerDetailsRepo.save(results);

            return "customer updated";
        }else
            return "invalid customer id";


    }
    @Override
    public String deletebyId(Long id){
        if(customerDetailsRepo.findById(id).isPresent()) {
            customerDetailsRepo.deleteById(id);
            return "User deleted";
        }else
            return "user not found";

    }

    @Override
    public List<CustomerDetails> readAll() {
        return customerDetailsRepo.findAll();
    }
}
