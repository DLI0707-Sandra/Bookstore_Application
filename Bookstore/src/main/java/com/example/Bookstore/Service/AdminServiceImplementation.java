package com.example.Bookstore.Service;

import com.example.Bookstore.DTO.AdminLoginDTO;
import com.example.Bookstore.Model.Admin;
import com.example.Bookstore.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

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

    public Admin loginAdmin(AdminLoginDTO admin) {
        Admin admin1 = adminRepository.findByUsername(admin.getUsername()).orElseThrow(() -> new RuntimeException("Admin not found"));
        if (admin1.getPassword().equals(admin.getPassword())) {
            return admin1;
        } else {
            throw new RuntimeException("Invalid password");
        }

    }
}
