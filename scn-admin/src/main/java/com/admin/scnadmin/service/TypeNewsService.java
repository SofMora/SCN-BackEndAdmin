package com.admin.scnadmin.service;

import com.admin.scnadmin.model.Professor;
import com.admin.scnadmin.model.TypeNews;
import com.admin.scnadmin.repository.admin.TypeNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class TypeNewsService {

    @Autowired
    private TypeNewsRepository typeNewsRepository;

    public List<TypeNews> getAllTypeNews() throws SQLException {
        return typeNewsRepository.findAll();
    }

    public TypeNews getTypeNews(long id) throws SQLException {
        Optional<TypeNews> optionalTypeNew = typeNewsRepository.findById(id);
        if (optionalTypeNew.isPresent()) {
            return optionalTypeNew.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Not data found"); // Lanza excepción si no se encuentra el estudiante
        }
    }

    public boolean saveTypeNews(TypeNews typeNew) {
        try{

            typeNewsRepository.save(typeNew);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }



    public boolean deleteTypeNews(long id) {
        try{
            typeNewsRepository.deleteById(id);
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }
}
