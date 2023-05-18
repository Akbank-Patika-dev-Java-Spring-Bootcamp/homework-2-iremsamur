package com.akbankbootcamp.ETradeBackend.controller.contract;

import com.akbankbootcamp.ETradeBackend.dto.comment.CommentDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserSaveRequestDTO;

import java.util.List;

public interface CommentControllerContract {
    CommentDTO add(CommentSaveRequestDTO request);
    CommentDTO update(CommentSaveRequestDTO commentSaveRequestDTO,Long commentId);

    List<CommentDTO> findAll();
    CommentDTO getById(Long id);

    void delete(Long id);
    List<CommentDTO> findAllByUserId(Long userId);
    List<CommentDTO> findAllByProductId(Long productId);
    UserDTO findUserById(Long userId);
    ProductDTO findProductById(Long productId);
}
