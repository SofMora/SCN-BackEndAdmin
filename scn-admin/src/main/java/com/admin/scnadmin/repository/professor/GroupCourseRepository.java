package com.admin.scnadmin.repository.professor;

import com.admin.scnadmin.model.GroupCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCourseRepository extends JpaRepository<GroupCourse, Long> {
}
