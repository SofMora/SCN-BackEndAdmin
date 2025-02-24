package com.admin.scnadmin.controller;

import com.admin.scnadmin.dto.NewsDTO;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins= "*")
@RestController//change in case you want to test the monolithic app
@RequestMapping(path="/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/getAllNews")
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        try {
            List<News> newsList = newsService.getAllPNews(); // Método para obtener todas las noticias
            List<NewsDTO> newsDTOList = new ArrayList<>();

            for (News news : newsList) {
                NewsDTO newsDTO = new NewsDTO();
                newsDTO.setId(news.getId());
                newsDTO.setTitle(news.getTitle());
                newsDTO.setAuthor(String.valueOf(news.getAuthor()));
                newsDTO.setTextNews(news.getTextNews());
                newsDTO.setDateNews(news.getDateNews());
                newsDTO.setTypeNews(String.valueOf(news.getTypeNews()));
                if (news.getImages() != null) {
                    // Convertir la imagen a Base64
                    String imageBase64 = Base64.getEncoder().encodeToString(news.getImages());
                    newsDTO.setImage("data:image/png;base64," + imageBase64);
                }
                newsDTOList.add(newsDTO);
            }

            return ResponseEntity.ok(newsDTOList);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping(path = "/saveNews", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveNews(@RequestBody NewsDTO newsDTO) {
        JSONObject response = new JSONObject();

        try {
            News news = new News();
            news.setTitle(newsDTO.getTitle());
            news.setAuthor(Integer.parseInt(newsDTO.getAuthor()));
            news.setTextNews(newsDTO.getTextNews());
            news.setDateNews(newsDTO.getDateNews());
            news.setTypeNews(Integer.parseInt(newsDTO.getTypeNews()));

            if(newsDTO.getImage() != null && !newsDTO.getImage().isEmpty()) {
                byte[] imageBytes = Base64.getDecoder().decode(newsDTO.getImage().split(",")[1]);
                news.setImages(imageBytes);
            }

            boolean result = newsService.saveNew(news);
            if (result) {
                response.put("message", "News added successfully");
                response.put("isSuccess", true);
                return ResponseEntity.ok(response.toString());
            } else {
                return ResponseEntity.badRequest().body("Error saving news");
            }

        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error saving news");
        }
    }

    @PostMapping("/deleteNewsById/{id}")
    public ResponseEntity<?> deleteNewsById(@PathVariable(value = "id") long id) {

        JSONObject response = new JSONObject();

        try {
            boolean result = newsService.deleteNews(id);
            if (result) {
                //emailService.sendEmail("pmarin2592@gmail.com","Prueba de sistema", "Prueba de sistema");
                response.put("message", "News added successfully");
                response.put("isSuccess", true);
                return ResponseEntity.ok(response.toString());
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
