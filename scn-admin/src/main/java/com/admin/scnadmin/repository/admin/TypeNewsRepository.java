package com.admin.scnadmin.repository.admin;


import com.admin.scnadmin.model.TypeNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeNewsRepository extends JpaRepository<TypeNews, Long> {
}
