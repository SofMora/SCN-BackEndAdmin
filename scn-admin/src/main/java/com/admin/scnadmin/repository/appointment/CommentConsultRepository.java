package com.admin.scnadmin.repository.appointment;

import com.admin.scnadmin.model.CommentConsult;
import com.admin.scnadmin.model.ConsultAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentConsultRepository extends JpaRepository<CommentConsult, Long> {

    @Query(value = "SELECT a.Id, a.DescriptionConsult, " +
            "CASE WHEN a.TypeConsult = 1 THEN 'Publica' ELSE 'Privada' END AS DesTypeConsult, a.TypeConsult, " +
            "a.DateConsult, b.Name AS nameCourse, b.id AS courseId, " +
            "(c.Name + ' ' + c.LastName) AS Student, c.id as studenId " +
            "FROM SCN_AppointmentsDB.scn_appointments.Consult a " +
            "INNER JOIN SCN_ProfessorDB.scn_professor.Course b ON b.Id = a.IdCourse " +
            "INNER JOIN SCN_StudentDB.scn_student.Student c ON c.Id = a.Author",
            nativeQuery = true)
    List<Object[]> findCommentConsult();
}
