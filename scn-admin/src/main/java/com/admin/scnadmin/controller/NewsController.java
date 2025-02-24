package com.admin.scnadmin.controller;

import com.admin.scnadmin.model.News;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.service.NewsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/getAllNews")
    public List<News> getAllNews() {
        try {
            return newsService.getAllPNews();
        } catch (SQLException ex) {
            return (List<News>) ResponseEntity
                    .badRequest()
                    .body("Error loading professor list");
        }
    }


    @PostMapping("/saveNews")
    public ResponseEntity<String> saveNews(@RequestParam("title") String title,
                                      @RequestParam("author") int author,
                                      @RequestParam("textNews") String textNews,
                                      @RequestParam("dateNews") LocalDateTime dateNews,
                                      @RequestParam(value = "image", required = false) MultipartFile image,
                                      @RequestParam("typeNews") int typeNews
                                      ) {

        JSONObject response = new JSONObject();

        try {
            News news = new News();
            news.setTitle(title);
            news.setAuthor(author);
            news.setTextNews(textNews);
            news.setDateNews(dateNews);
            news.setTypeNews(typeNews);

            if(image!=null && !image.isEmpty()) {
                news.setImages(image.getBytes());
            }

            boolean result = newsService.saveNew(news);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                response.put("message", "Employee added successfully");
                response.put("isSuccess", true);
                return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error save New ");
        }
    }

    @PostMapping("/deleteNewsById/{id}")
    public ResponseEntity<?> deleteNewsById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = newsService.deleteNews(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                return new ResponseEntity<>("Ready", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .badRequest()
                    .body("Error delete News ");
        }
    }

    @GetMapping("/getNewsDetailById/{id}")
    public ResponseEntity<News> get(@PathVariable Integer id) {
        try {
            News news = newsService.getNews(id);
            return new ResponseEntity<>(news, HttpStatus.OK);
        } catch (SQLException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
