package com.admin.scnadmin.service;

import com.admin.scnadmin.model.CommentConsult;
import com.admin.scnadmin.model.ConsultAppointment;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.appointment.CommentConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class CommentConsultService {

    @Autowired
    private CommentConsultRepository commentConsultRepository;


    public List<CommentConsult> getAllCommentConsult() throws SQLException {
        return commentConsultRepository.findAll();
    }

    public CommentConsult getConsultCommentConsult(long id) throws SQLException {
        Optional<CommentConsult> optionalCommentConsult = commentConsultRepository.findById(id);
        if (optionalCommentConsult.isPresent()) {
            return optionalCommentConsult.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Consult Appointment not found"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveCommentConsult(CommentConsult commentConsult) throws SQLException {
        try{

            commentConsultRepository.save(commentConsult);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean deleteCommentConsult(long id) {
        try{
            commentConsultRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public List<Map<String, Object>> findCommentConsult() {
        List<Object[]> results = commentConsultRepository.findCommentConsult();
        List<Map<String, Object>> courses = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> courseData = new HashMap<>();
            courseData.put("Id", row[0]);
            courseData.put("DescriptionConsult", row[1]);
            courseData.put("DesTypeConsult", row[2]);
            courseData.put("TypeConsult", row[3]);
            courseData.put("DateConsult", row[4]);
            courseData.put("nameCourse", row[5]);
            courseData.put("courseId", row[6]);
            courseData.put("Student", row[7]);
            courseData.put("studenId", row[8]);
            courses.add(courseData);
        }
        return courses;
    }
}
