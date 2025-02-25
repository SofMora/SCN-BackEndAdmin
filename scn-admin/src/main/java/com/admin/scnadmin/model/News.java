package com.admin.scnadmin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "News", schema = "scn_admin")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "Title")
    private String title;

    @Column(name= "Author")
    private int author;

    @Column(name= "TextNews")
    private String textNews;

    @Column(name = "DateNews")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") // ✅ Acepta 'Z' o '+00:00'
    private LocalDateTime dateNews;

    @Column(name= "Images", columnDefinition = "LONGBLOB")
    private byte[] images;

    @Column(name= "TypeNews")
    private int typeNews;

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

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTextNews() {
        return textNews;
    }

    public void setTextNews(String textNews) {
        this.textNews = textNews;
    }

    public LocalDateTime getDateNews() {
        return dateNews;
    }

    public void setDateNews(LocalDateTime dateNews) {
        this.dateNews = dateNews;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public int getTypeNews() {
        return typeNews;
    }

    public void setTypeNews(int typeNews) {
        this.typeNews = typeNews;
    }
}
