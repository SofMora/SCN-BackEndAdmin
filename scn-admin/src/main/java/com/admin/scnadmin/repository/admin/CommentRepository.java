package com.admin.scnadmin.repository.admin;

import com.admin.scnadmin.model.Comment;
import com.admin.scnadmin.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
