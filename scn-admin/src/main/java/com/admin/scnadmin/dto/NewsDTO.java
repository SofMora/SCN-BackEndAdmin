package com.admin.scnadmin.dto;

import java.time.LocalDateTime;

public class NewsDTO {
    private long id;
    private String title;
    private String author;
    private String textNews;
    private LocalDateTime dateNews;
    private String image;
    private String typeNews;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeNews() {
        return typeNews;
    }

    public void setTypeNews(String typeNews) {
        this.typeNews = typeNews;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDateNews() {
        return dateNews;
    }

    public void setDateNews(LocalDateTime dateNews) {
        this.dateNews = dateNews;
    }

    public String getTextNews() {
        return textNews;
    }

    public void setTextNews(String textNews) {
        this.textNews = textNews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
