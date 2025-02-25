package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Comment;
import com.admin.scnadmin.model.News;
import com.admin.scnadmin.repository.admin.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComment() throws SQLException {
        return commentRepository.findAll();
    }

    public Comment getComment(long id) throws SQLException {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            return optionalComment.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Professor no encontrado"); // Lanza excepción si no se encuentra el estudiante
        }
    }


    public boolean deleteComment(long id) {
        try{
            commentRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
