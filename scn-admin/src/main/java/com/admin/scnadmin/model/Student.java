package com.admin.scnadmin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student", schema = "scn_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "Name")
    private String name;

    @Column(name= "LastName")
    private String lastName;

    @Column(name= "Email")
    private String email;

    @Column(name= "Password")
    private String password;

    @Column(name= "Username")
    private String username;

    @Column(name= "StatusStudent")
    private boolean statusStudent;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatusStudent() {
        return statusStudent;
    }

    public void setStatusStudent(boolean statusStudent) {
        this.statusStudent = statusStudent;
    }
}
