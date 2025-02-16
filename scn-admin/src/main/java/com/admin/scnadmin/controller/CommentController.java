package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.Comment;
import com.admin.scnadmin.model.Course;
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
@RequestMapping(path="/api/commentNews")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getAllComment")
    public List<Comment> getAllComment() {
        try {
            return commentService.getAllComment();
        } catch (SQLException ex) {
            return (List<Comment>) ResponseEntity
                    .badRequest()
                    .body("Error loading Course list");
        }
    }


    @PostMapping("/deleteCommentById/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = commentService.deleteComment(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error delete Comment ");
        }
    }

    @GetMapping("/getCommentDetailById/{id}")
    public ResponseEntity<Comment> get(@PathVariable Integer id) {
        try {
            Comment comment = commentService.getComment(id);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
