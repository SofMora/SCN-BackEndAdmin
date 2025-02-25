package com.admin.scnadmin.controller;


import com.admin.scnadmin.dto.StudentDTO;
import com.admin.scnadmin.model.Student;
import com.admin.scnadmin.service.EmailService;
import com.admin.scnadmin.service.StudentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        try {
            return studentService.getAllStudent();
        } catch (SQLException ex) {
            return (List<Student>) ResponseEntity
                    .badRequest()
                    .body("Error loading employee list");
        }
    }

    @GetMapping("/getPendingStudents")
    public List<StudentDTO> getPendingStudents() {
        try {
            return studentService.getInactiveStudents();
        } catch (SQLException ex) {
            return (List<StudentDTO>) ResponseEntity
                    .badRequest()
                    .body("Error loading employee list");
        }
    }

    @PostMapping("/approvalStudent/{id}")
    //@RequestMapping(method = RequestMethod.POST, value = "/deleteEmployeeById/{id}", produces="application/json")
    public ResponseEntity<?> approvalStudent(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            Student student = studentService.getStudent(id);
            boolean result = studentService.updateAprovalStudent(student,true);
            if (result) {
                emailService.sendEmail(student.getEmail(),"Registro aprobado", "Estimado estudiante \n Se le informa" +
                        "que su registro fue aprobado por el administrador.\n Saludos.");
                response.put("message", "student approval successfully");
                response.put("isSuccess", true);
                return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (SQLException ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error approval student ");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/denegateStudent/{id}")
    //@RequestMapping(method = RequestMethod.POST, value = "/deleteEmployeeById/{id}", produces="application/json")
    public ResponseEntity<?> denegateStudent(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            Student student = studentService.getStudent(id);
            boolean result = studentService.updateAprovalStudent(student,false);
            if (result) {
                emailService.sendEmail(student.getEmail(),"Registro denegado", "Estimado estudiante \n Se le informa" +
                        "que su registro fue denegado por el administrador.\n Saludos.");
                response.put("message", "student approval successfully");
                response.put("isSuccess", true);
                return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error approval student ");
        }
    }


}
