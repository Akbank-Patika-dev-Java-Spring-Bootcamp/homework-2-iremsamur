package com.akbankbootcamp.ETradeBackend.controller.contract.impl;

import com.akbankbootcamp.ETradeBackend.controller.contract.CommentControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByUserDTO;
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

import java.util.ArrayList;
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
    public List<CommentByUserDTO> findAllByUserId(Long userId) {
        List<CommentByUserDTO> commentByUserListDTO = new ArrayList<CommentByUserDTO>();
        List<Comment> commentsByUser = commentEntityService.getRepository().findAllByUserId(userId);
        if(commentsByUser == null){
            return commentByUserListDTO;
        }
        else{
            for (Comment comment : commentsByUser) {
                CommentByUserDTO commentUserDTO = new CommentByUserDTO();
                commentUserDTO.setId(comment.getId());
                commentUserDTO.setUserId(comment.getUser().getId());
                commentUserDTO.setProductId(comment.getProduct().getId());
                commentUserDTO.setComment(comment.getComment());
                commentUserDTO.setStatus(comment.getStatus());
                commentUserDTO.setCreatedAt(comment.getCreatedAt());
                commentUserDTO.setUsername(comment.getUser().getUsername());
                commentUserDTO.setName(comment.getUser().getName());
                commentUserDTO.setSurname(comment.getUser().getSurname());
                commentByUserListDTO.add(commentUserDTO);
            }
            return commentByUserListDTO;
        }

    }

    @Override
    public List<CommentByProductDTO> findAllByProductId(Long productId) {
        List<CommentByProductDTO> commentByProductListDTO = new ArrayList<CommentByProductDTO>();
        List<Comment> commentsForProduct = commentEntityService.getRepository().findAllByProductId(productId);
        if(commentsForProduct == null){
            return commentByProductListDTO;
        }
        else{
            for (Comment comment : commentsForProduct) {
                CommentByProductDTO commentProductDTO = new CommentByProductDTO();
                commentProductDTO.setId(comment.getId());
                commentProductDTO.setUserId(comment.getUser().getId());
                commentProductDTO.setProductId(comment.getProduct().getId());
                commentProductDTO.setComment(comment.getComment());
                commentProductDTO.setStatus(comment.getStatus());
                commentProductDTO.setCreatedAt(comment.getCreatedAt());
                commentProductDTO.setName(comment.getProduct().getName());
                commentByProductListDTO.add(commentProductDTO);
            }
            return commentByProductListDTO;
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
