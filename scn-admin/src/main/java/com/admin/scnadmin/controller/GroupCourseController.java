package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.GroupCourse;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.professor.GroupCourseRepository;
import com.admin.scnadmin.service.GroupCourseServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/groups")
public class GroupCourseController {

    @Autowired
    private GroupCourseServices groupCourseServices;

    @GetMapping("/getAllGroups")
    public List<GroupCourse> getAllGroups() {
        try {
            return groupCourseServices.getAllgroupCourse();
        } catch (SQLException ex) {
            return (List<GroupCourse>) ResponseEntity
                    .badRequest()
                    .body("Error loading professor list");
        }
    }

    @PostMapping("/saveGroups")
    public ResponseEntity<?> saveProfessor(@RequestBody GroupCourse groupCourse) {

        JSONObject response = new JSONObject();

        try {
            boolean result = groupCourseServices.saveGroupCourse(groupCourse);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error save group course ");
        }
    }


    @PostMapping("/deleteGroupsById/{id}")
    public ResponseEntity<?> deleteGroupsById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = groupCourseServices.deleteGroupCourse(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error delete group " +
                            "course ");
        }
    }

    @GetMapping("/getGroupDetailById/{id}")
    public ResponseEntity<GroupCourse> get(@PathVariable Integer id) {
        try {
            GroupCourse groupCourse = groupCourseServices.getGroupCourse(id);
            return new ResponseEntity<>(groupCourse, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
