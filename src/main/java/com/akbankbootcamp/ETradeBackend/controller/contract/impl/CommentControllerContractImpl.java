package com.akbankbootcamp.ETradeBackend.controller.contract.impl;

import com.akbankbootcamp.ETradeBackend.controller.contract.CommentControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserDTO;
import com.akbankbootcamp.ETradeBackend.entity.Comment;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.entity.User;
import com.akbankbootcamp.ETradeBackend.mapper.CommentMapper;
import com.akbankbootcamp.ETradeBackend.mapper.ProductMapper;
import com.akbankbootcamp.ETradeBackend.mapper.UserMapper;
import com.akbankbootcamp.ETradeBackend.service.entityservice.CommentEntityService;
import com.akbankbootcamp.ETradeBackend.service.entityservice.ProductEntityService;
import com.akbankbootcamp.ETradeBackend.service.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentControllerContractImpl implements CommentControllerContract {
    private final CommentEntityService commentEntityService;
    private final UserEntityService userEntityService;
    private final ProductEntityService productEntityService;
    @Autowired
    public CommentControllerContractImpl(CommentEntityService commentEntityService, UserEntityService userEntityService, ProductEntityService productEntityService) {
        this.commentEntityService = commentEntityService;
        this.userEntityService = userEntityService;
        this.productEntityService = productEntityService;
    }
    @Override
    public CommentDTO add(CommentSaveRequestDTO request) {
        Product product = productEntityService.findById(request.getProductId()).orElseThrow();
        User user = userEntityService.findById(request.getUserId()).orElseThrow();
        if(user!=null && product!=null){
            Comment comment = CommentMapper.INSTANCE.convertToComment(request);
            comment.setProduct(product);
            comment.setUser(user);
            comment = commentEntityService.save(comment);
            return CommentMapper.INSTANCE.convertToCommentDTO(comment);
        }
        return new CommentDTO();

    }

    @Override
    public CommentDTO update(CommentSaveRequestDTO commentSaveRequestDTO, Long commentId) {
        Comment comment = commentEntityService.findById(commentId).orElse(null);
        Product product = productEntityService.findById(commentSaveRequestDTO.getProductId()).orElseThrow();
        User user = userEntityService.findById(commentSaveRequestDTO.getUserId()).orElseThrow();
        if(user!=null && product!=null){
            comment.setUser(user);
            comment.setProduct(product);
            comment.setComment(commentSaveRequestDTO.getComment());
            comment.setStatus(commentSaveRequestDTO.getStatus());
            comment.setCreatedAt(commentSaveRequestDTO.getCreatedAt());
            comment = commentEntityService.save(comment);
            return CommentMapper.INSTANCE.convertToCommentDTO(comment);
        }
        return new CommentDTO();
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> commentList = commentEntityService.findAll();
        return CommentMapper.INSTANCE.convertToCommentDTOList(commentList);
    }

    @Override
    public CommentDTO getById(Long id) {
        Comment comment = commentEntityService.findById(id).orElse(null);
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public void delete(Long id) {
        commentEntityService.delete(id);
    }

    @Override
    public List<CommentDTO> findAllByUserId(Long userId) {
        List<CommentDTO> commentDTO = null;
        List<Comment> commentsByUser = commentEntityService.getRepository().findAllByUserId(userId);
        if(commentsByUser == null){
            return commentDTO;
        }
        else{
            return CommentMapper.INSTANCE.convertToCommentDTOList(commentsByUser);
        }

    }

    @Override
    public List<CommentDTO> findAllByProductId(Long productId) {
        List<CommentDTO> commentDTO = null;
        List<Comment> commentsForProduct = commentEntityService.getRepository().findAllByProductId(productId);
        if(commentsForProduct == null){
            return commentDTO;
        }
        else{
            return CommentMapper.INSTANCE.convertToCommentDTOList(commentsForProduct);
        }
    }

    @Override
    public UserDTO findUserById(Long userId) {
        User user = userEntityService.findById(userId).orElse(null);;
        return UserMapper.INSTANCE.convertToUserDTO(user);

    }

    @Override
    public ProductDTO findProductById(Long productId) {
        Product product = productEntityService.findById(productId).orElse(null);;
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }
}
