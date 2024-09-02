package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.AdminLoginDTO;
import com.example.Bookstore.Model.Admin;
import com.example.Bookstore.Model.Users;
import com.example.Bookstore.Repository.AdminRepository;
import com.example.Bookstore.util.TokenUtillity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private  TokenUtillity tokenUtillity;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setUsername(adminDetails.getUsername());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(adminDetails.getPassword());
        admin.setCreated_at(adminDetails.getCreated_at());
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public String loginAdmin(AdminLoginDTO admin) {
        Admin admin1 = adminRepository.findByUsername(admin.getUsername()).orElseThrow(() -> new RuntimeException("Admin not found"));
        if (admin1.getPassword().equals(admin.getPassword())) {
            return  tokenUtillity.generateToken( admin1.getUsername());
        } else {
            return "Invalid password";
        }

    }
}

//Users user =  usersRepo.findByUserName( loginDTO.getUserName());
//        if(user==null)
//        throw new UserNotFoundException("Invalid credentials");
//
//        if (passwordEncoder.matches( loginDTO.getPassword(),  user.getPassword())) {
//        return  tokenUtillity.generateToken( user.getUserName());
//        } else {
//        throw new BadCredentialsException("Invalid credentials");
//        }
