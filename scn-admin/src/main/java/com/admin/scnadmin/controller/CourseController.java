package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.*;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse() {
        try {
            return courseService.getAllCourse();
        } catch (SQLException ex) {
            return (List<Course>) ResponseEntity
                    .badRequest()
                    .body("Error loading Course list");
        }
    }

    @PostMapping("/saveCourse")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {

        //JSONObject response = new JSONObject();
        Map<String, Object> response = new HashMap<>();


        try {
            boolean result = courseService.saveCourse(course);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                response.put("message", "Course added successfully");
                response.put("isSuccess", true);
                return new ResponseEntity<String>(response.toString(), HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                   .body("Error save professor ");

        }
    }


    @PostMapping("/deleteCourseById/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = courseService.deleteCourse(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error deleted course");
        }
    }

    @GetMapping("/getCourseDetailById/{id}")
    public ResponseEntity<Course> get(@PathVariable Integer id) {
        try {
            Course course = courseService.getCourse(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getwithprofessor")
    public List<Map<String, Object>> getCoursesWithProfessor() {
        return courseService.getCoursesWithProfessor();
    }
}
