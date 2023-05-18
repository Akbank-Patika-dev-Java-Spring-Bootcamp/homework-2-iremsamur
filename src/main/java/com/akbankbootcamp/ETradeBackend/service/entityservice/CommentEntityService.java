package com.akbankbootcamp.ETradeBackend.service.entityservice;

import com.akbankbootcamp.ETradeBackend.dao.CommentRepository;
import com.akbankbootcamp.ETradeBackend.dao.ProductRepository;
import com.akbankbootcamp.ETradeBackend.dao.UserRepository;
import com.akbankbootcamp.ETradeBackend.entity.Comment;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {

    private CommentRepository repository;

    @Autowired
    public CommentEntityService(CommentRepository repository) {
        super(repository);
        this.repository = repository;
    }
    public CommentRepository getRepository() {
        return repository;
    }

    public void setRepository(CommentRepository repository) {
        this.repository = repository;
    }



}
