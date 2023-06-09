package com.akbankbootcamp.ETradeBackend.entity;

import com.akbankbootcamp.ETradeBackend.enums.EnumStatus;
import com.akbankbootcamp.ETradeBackend.general.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 100, nullable = false)
    private String description;

    @Column(name = "PRICE", length = 100, nullable = false)
    private Double price;

    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



}
