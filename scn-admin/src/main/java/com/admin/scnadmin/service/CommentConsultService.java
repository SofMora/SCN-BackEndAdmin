package com.admin.scnadmin.service;

import com.admin.scnadmin.model.CommentConsult;
import com.admin.scnadmin.model.ConsultAppointment;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.appointment.CommentConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
}
