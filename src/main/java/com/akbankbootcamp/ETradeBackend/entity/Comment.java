package com.akbankbootcamp.ETradeBackend.entity;

import com.akbankbootcamp.ETradeBackend.enums.EnumStatus;
import com.akbankbootcamp.ETradeBackend.general.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@Getter
@Setter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ")
    private Long id;
    @Column(name = "COMMENT", length = 100, nullable = false)
    private String comment;

    /*
    @Column(name = "INDIVIDUAL_ID")
    private Long userId;
    @Column(name = "PRODUCT_ID")
    private Long productId;

     */


    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "INDIVIDUAL_ID", nullable = false)
    private User user;



    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdAt;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
