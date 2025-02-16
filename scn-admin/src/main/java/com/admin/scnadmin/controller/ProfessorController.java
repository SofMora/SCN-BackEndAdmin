package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.service.ProfessorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/professor")
public class ProfessorController {

  @Autowired
  private ProfessorService professorService;

    @GetMapping("/getAllProfessor")
    public List<Professor> getAllProfessor() {
        try {
            return professorService.getAllProfessor();
        } catch (SQLException ex) {
            return (List<Professor>) ResponseEntity
                    .badRequest()
                    .body("Error loading professor list");
        }
    }

    @PostMapping("/saveProfessor")
    public ResponseEntity<?> saveProfessor(@RequestBody Professor professor) {

        JSONObject response = new JSONObject();

        try {
            boolean result = professorService.saveProfessor(professor);
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

    @PostMapping("/updateProfessor")
    public ResponseEntity<?> updateProfessor(@RequestBody Professor professor) {

        JSONObject response = new JSONObject();

        try {
            boolean result = professorService.updateProfessor(professor);
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

    @PostMapping("/deleteProfessorById/{id}")
    public ResponseEntity<?> deleteProfessorById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = professorService.deleteProfessor(id);
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

    @GetMapping("/getProfessorDetailById/{id}")
    public ResponseEntity<Professor> get(@PathVariable Integer id) {
        try {
            Professor professor = professorService.getProfessor(id);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
