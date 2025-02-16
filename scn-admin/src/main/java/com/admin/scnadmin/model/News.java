package com.admin.scnadmin.model;

import jakarta.persistence.*;

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
    private String dateNews;

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

    public String getDateNews() {
        return dateNews;
    }

    public void setDateNews(String dateNews) {
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
