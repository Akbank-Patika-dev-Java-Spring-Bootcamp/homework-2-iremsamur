package com.akbankbootcamp.ETradeBackend.dto.comment;

import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.entity.User;
import com.akbankbootcamp.ETradeBackend.enums.EnumStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentSaveRequestDTO {
    private String comment;
    private Long productId;
    private Long userId;
    private EnumStatus status;
    private LocalDateTime createdAt;
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
