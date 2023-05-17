package com.akbankbootcamp.ETradeBackend.dao;

import com.akbankbootcamp.ETradeBackend.entity.Comment;
import com.akbankbootcamp.ETradeBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(Long userId);

    List<Comment> findByProductId(Long productId);
}
