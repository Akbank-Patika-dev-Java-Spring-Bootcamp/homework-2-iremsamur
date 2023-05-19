package com.akbankbootcamp.ETradeBackend.mapper;

import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByUserDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.entity.Comment;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertToComment(CommentSaveRequestDTO commentSaveRequestDTO);

    CommentDTO convertToCommentDTO(Comment comment);
    CommentByUserDTO convertToCommentByUserDTO(Comment comment);
    CommentByProductDTO convertToCommentByProductDTO(Comment comment);
    List<CommentByProductDTO> convertToCommentByProductListDTO(List<Comment> comment);

    List<CommentDTO> convertToCommentDTOList(List<Comment> commentList);

}
