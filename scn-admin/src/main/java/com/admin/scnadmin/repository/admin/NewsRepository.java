package com.admin.scnadmin.repository.admin;

import com.admin.scnadmin.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE News n SET n.title = :title, n.textNews = :textNews, " +
            "n.images = CASE WHEN :images IS NULL THEN n.images ELSE :images END " +
            "WHERE n.id = :id")
    int updateNews(Long id, String title, String textNews, byte[] images);
}
