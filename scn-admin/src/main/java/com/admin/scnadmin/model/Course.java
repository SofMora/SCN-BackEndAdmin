package com.admin.scnadmin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Course", schema = "scn_professor")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "Name")
    private String name;

    @Column(name = "Cycle")
    private int cycle;

    @Column(name = "StatusCourse")
    private boolean statusCourse;

    @Column(name = "Description")
    private String description;

    @Column(name = "idProfessor")
    private int idProfessor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public boolean isStatusCourse() {
        return statusCourse;
    }

    public void setStatusCourse(boolean statusCourse) {
        this.statusCourse = statusCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
