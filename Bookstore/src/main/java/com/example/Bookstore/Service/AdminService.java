package com.example.Bookstore.Service;
import com.example.Bookstore.DTO.AdminLoginDTO;
import com.example.Bookstore.Model.Admin;
import com.example.Bookstore.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AdminService {


     public List<Admin> getAllAdmins() ;

    public Optional<Admin> getAdminById(Long id) ;

    public Admin createAdmin(Admin admin) ;

    public Admin updateAdmin(Long id, Admin adminDetails) ;

    public void deleteAdmin(Long id) ;

    public String loginAdmin(AdminLoginDTO admin) ;

}
