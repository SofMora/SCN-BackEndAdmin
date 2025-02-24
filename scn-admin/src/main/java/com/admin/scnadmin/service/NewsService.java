package com.admin.scnadmin.service;

import com.admin.scnadmin.model.News;
import com.admin.scnadmin.repository.admin.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean updateNews(Long id, String title,String textNews, byte[] images) {
        try{
            newsRepository.updateNews(id,title,textNews,images);
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
