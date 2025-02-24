package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.professor.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

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

    public List<Map<String, Object>> getCoursesWithProfessor() {
        List<Object[]> results = courseRepository.findCoursesByProfessor();
        List<Map<String, Object>> courses = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> courseData = new HashMap<>();
            courseData.put("id", row[0]);
            courseData.put("name", row[1]);
            courseData.put("cycle", row[2]);
            courseData.put("statusCourse", row[3]);
            courseData.put("description", row[4]);
            courseData.put("idProfessor", row[5]);
            courseData.put("nameProfessor", row[6]); // Este es el alias corregido
            courses.add(courseData);
        }
        return courses;
    }

}
