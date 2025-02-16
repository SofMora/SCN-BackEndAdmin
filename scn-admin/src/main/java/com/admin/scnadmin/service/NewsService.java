package com.admin.scnadmin.service;

import com.admin.scnadmin.model.News;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.admin.NewsRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllPNews() throws SQLException{
        return newsRepository.findAll();
    }

    public News getNews(long id) throws SQLException {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            return optionalNews.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Professor no encontrado"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveNew(News news) {
        try{

            newsRepository.save(news);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean updateNews(News news) {
        try{
            newsRepository.save(news);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean deleteNews(long id) {
        try{
            newsRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

}
