package com.admin.scnadmin.controller;


import com.admin.scnadmin.model.Admin;
import com.admin.scnadmin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/administrator")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin() {
        try{
            return adminService.getAllAdmin();
        }catch (SQLException ex)
        {
            return (List<Admin>) ResponseEntity
                    .badRequest()
                    .body("Error loading Administrator list");
        }
    }

    @PostMapping("/validateUser")
    public ResponseEntity<Admin> validateUser(@RequestBody Map<String, String> credentials) throws Exception {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Admin admin = adminService.validateUser(username, password);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }



}
