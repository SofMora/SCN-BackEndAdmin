package com.admin.scnadmin.repository.student;


import com.admin.scnadmin.dto.StudentDTO;
import com.admin.scnadmin.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<StudentDTO> findByStatusStudentFalse();

    List<StudentDTO> findByStatusStudentIsNull();
}
