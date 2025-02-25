package com.admin.scnadmin.repository.professor;

import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT a.Id, a.Name, a.Cycle, a.StatusCourse, a.Description, " +
            "a.IdProfessor, b.Name AS NameProfessor " +
            "FROM SCN_ProfessorDB.scn_professor.Course a " +
            "INNER JOIN SCN_ProfessorDB.scn_professor.Professors b ON b.Id = a.IdProfessor",
            nativeQuery = true)
    List<Object[]> findCoursesByProfessor();
}
