package com.akbankbootcamp.ETradeBackend.service.entityservice;

import com.akbankbootcamp.ETradeBackend.dao.CommentRepository;
import com.akbankbootcamp.ETradeBackend.dao.ProductRepository;
import com.akbankbootcamp.ETradeBackend.entity.Comment;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.general.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {
    public CommentEntityService(CommentRepository repository) {
        super(repository);
    }
}
