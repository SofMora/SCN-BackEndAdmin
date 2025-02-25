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
        Optional<Student> optionalStudent = studentRepository.findById(id).map(student -> {
            // Si el statusStudent es null, se asigna false

                student.setStatusStudent(false);

            return student;
        });

        if (optionalStudent.isPresent()) {
            // Si el Optional no está vacío, verificamos el valor de statusStudent
            Student student = optionalStudent.orElseGet(() -> {
                Student defaultStudent = new Student();
                defaultStudent.setStatusStudent(false); // Si el student es nulo, setea el statusStudent como false
                return defaultStudent;
            });

            return student;

        } else {
            throw new SQLException("Student not found"); // Lanza excepción si no se encuentra el estudiante
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
