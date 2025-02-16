package com.admin.scnadmin.repository.professor;

import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
