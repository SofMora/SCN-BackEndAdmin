package com.admin.scnadmin.service;

import com.admin.scnadmin.dto.StudentDTO;
import com.admin.scnadmin.model.Student;
import com.admin.scnadmin.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent() throws SQLException {
        return studentRepository.findAll();
    }

    public List<StudentDTO> getInactiveStudents() throws SQLException {
        return studentRepository.findByStatusStudentIsNull();
    }

    public Student getStudent(long id) throws SQLException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Estudiante no encontrado"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean updateAprovalStudent(Student student, boolean status) {
        try{
            student.setStatusStudent(status);
            studentRepository.save(student);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
