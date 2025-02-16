package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.professor.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourse() throws SQLException {
        return courseRepository.findAll();
    }

    public Course getCourse(long id) throws SQLException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Course not found"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveCourse(Course course) {
        try{
            courseRepository.save(course);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean deleteCourse(long id) {
        try{
            courseRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

}
