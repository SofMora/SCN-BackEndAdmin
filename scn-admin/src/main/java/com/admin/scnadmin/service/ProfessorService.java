package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessor() throws SQLException{
        return professorRepository.findAll();
    }

    public Professor getProfessor(long id) throws SQLException {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            return optionalProfessor.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Professor no encontrado"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveProfessor(Professor professor) {
        try{

            professorRepository.save(professor);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean updateProfessor(Professor professor) {
        try{
            professorRepository.save(professor);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean deleteProfessor(long id) {
        try{
            professorRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }





}
