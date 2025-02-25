package com.admin.scnadmin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Consult", schema = "scn_appointments")
public class ConsultAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IdCourse")
    private int idCourse;

    @Column(name = "DescriptionConsult")
    private String descriptionConsult;

    @Column(name = "TypeConsult")
    private boolean typeConsult;

    @Column(name = "Author")
    private int author;

    @Column(name = "DateConsult")
    private String dateConsult;

    @Column(name = "StatusConsult")
    private boolean statusConsult;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescriptionConsult() {
        return descriptionConsult;
    }

    public void setDescriptionConsult(String descriptionConsult) {
        this.descriptionConsult = descriptionConsult;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public boolean isTypeConsult() {
        return typeConsult;
    }

    public void setTypeConsult(boolean typeConsult) {
        this.typeConsult = typeConsult;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getDateConsult() {
        return dateConsult;
    }

    public void setDateConsult(String dateConsult) {
        this.dateConsult = dateConsult;
    }

    public boolean isStatusConsult() {
        return statusConsult;
    }

    public void setStatusConsult(boolean statusConsult) {
        this.statusConsult = statusConsult;
    }
}
