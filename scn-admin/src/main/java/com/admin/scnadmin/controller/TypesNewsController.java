package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.model.TypeNews;
import com.admin.scnadmin.service.TypeNewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/typeNews")
public class TypesNewsController {

    @Autowired
    private TypeNewsService typeNewsService;

    @GetMapping("/getAllTypeNews")
    public List<TypeNews> getAllTypeNews() {
        try {
            return typeNewsService.getAllTypeNews();
        } catch (SQLException ex) {
            return (List<TypeNews>) ResponseEntity
                    .badRequest()
                    .body("Error loading professor list");
        }
    }

    @PostMapping("/saveTypeNews")
    public ResponseEntity<?> saveTypeNews(@RequestBody TypeNews typeNews) {

        JSONObject response = new JSONObject();

        try {
            boolean result = typeNewsService.saveTypeNews(typeNews);
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


    @PostMapping("/deleteTypeNewsById/{id}")
    public ResponseEntity<?> deleteTypeNewsById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = typeNewsService.deleteTypeNews(id);
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

    @GetMapping("/getTypeNewsDetailById/{id}")
    public ResponseEntity<TypeNews> get(@PathVariable Integer id) {
        try {
            TypeNews typeNews = typeNewsService.getTypeNews(id);
            return new ResponseEntity<>(typeNews, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
