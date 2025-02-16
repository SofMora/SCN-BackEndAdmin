package com.admin.scnadmin.service;

import com.admin.scnadmin.model.GroupCourse;
import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.repository.professor.GroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class GroupCourseServices {

    @Autowired
    private GroupCourseRepository groupCourseRepository;

    public List<GroupCourse> getAllgroupCourse() throws SQLException {
        return groupCourseRepository.findAll();
    }

    public GroupCourse getGroupCourse(long id) throws SQLException {
        Optional<GroupCourse> optionalGroupCourse = groupCourseRepository.findById(id);
        if (optionalGroupCourse.isPresent()) {
            return optionalGroupCourse.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Professor no encontrado"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveGroupCourse(GroupCourse professor) {
        try{

            groupCourseRepository.save(professor);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean deleteGroupCourse(long id) {
        try{
            groupCourseRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

}
