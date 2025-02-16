package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.CommentConsult;
import com.admin.scnadmin.model.ConsultAppointment;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.service.CommentConsultService;
import com.admin.scnadmin.service.CommentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/appointmentComment")
public class CommentConsultController {

    @Autowired
    private CommentConsultService commentConsultService;


    @GetMapping("/getAllAppointmentComment")
    public List<CommentConsult> getAllAppointmentComment() {
        try {
            return commentConsultService.getAllCommentConsult();
        } catch (SQLException ex) {
            return (List<CommentConsult>) ResponseEntity
                    .badRequest()
                    .body("Error loading Course list");
        }
    }

    @GetMapping("/getgetAllAppointmentCommentDetailById/{id}")
    public ResponseEntity<CommentConsult> get(@PathVariable Integer id) {
        try {
            CommentConsult commentConsult = commentConsultService.getConsultCommentConsult(id);
            return new ResponseEntity<>(commentConsult, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveAppointmentComment")
    public ResponseEntity<?> saveAppointmentComment(@RequestBody CommentConsult commentConsult) {

        JSONObject response = new JSONObject();

        try {
            boolean result = commentConsultService.saveCommentConsult(commentConsult);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error save professor ");
        }
    }

    @PostMapping("/deleteAppointmentCommentById/{id}")
    public ResponseEntity<?> deleteAppointmentCommentById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = commentConsultService.deleteCommentConsult(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error delete professor ");
        }
    }
}
