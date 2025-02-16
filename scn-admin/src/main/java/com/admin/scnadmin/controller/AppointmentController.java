package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.ConsultAppointment;
import com.admin.scnadmin.service.ConsultAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/appointment")
public class AppointmentController {

    @Autowired
    private ConsultAppointmentService consultAppointmentService;

    @GetMapping("/getAllAppointment")
    public List<ConsultAppointment> getAllAppointment() {
        try {
            return consultAppointmentService.getAllConsultAppointment();
        } catch (SQLException ex) {
            return (List<ConsultAppointment>) ResponseEntity
                    .badRequest()
                    .body("Error loading Course list");
        }
    }

    @GetMapping("/getAppointmentDetailById/{id}")
    public ResponseEntity<ConsultAppointment> get(@PathVariable Integer id) {
        try {
            ConsultAppointment consultAppointment = consultAppointmentService.getConsultAppointment(id);
            return new ResponseEntity<>(consultAppointment, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
