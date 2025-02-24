package com.admin.scnadmin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CommentConsult", schema = "scn_appointments")
public class CommentConsult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IdConsult")
    @JsonProperty("idConsult") //
    private long idConsult;

    @Column(name = "DescriptionComment")
    @JsonProperty("descriptionComment")
    private String descriptionComment;

    @Column(name = "Author")
    @JsonProperty("author")
    private int author;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") // ✅ Acepta 'Z' o '+00:00'
    @Column(name = "DateComment")
    private LocalDateTime dateComment;

    public long getId() {
        return id;
    }

    public long getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(long idConsult) {
        this.idConsult = idConsult;
    }

    public String getDescriptionComment() {
        return descriptionComment;
    }

    public void setDescriptionComment(String descriptionComment) {
        this.descriptionComment = descriptionComment;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public LocalDateTime getDateComment() {
        return dateComment;
    }

    public void setDateComment(LocalDateTime dateComment) {
        this.dateComment = dateComment;
    }
}
