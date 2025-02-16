package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Admin;
import com.admin.scnadmin.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class AdminService {


    @Autowired
    private AdminRepository adminRepository;


    public List<Admin> getAllAdmin() throws SQLException {
        return adminRepository.findAll();
    }

    public Admin validateUser(String username, String password) throws SQLException{
        return adminRepository.findByUsernameAndPassword(username, password);
    }
}
