package com.akbankbootcamp.ETradeBackend.dto.product;

import com.akbankbootcamp.ETradeBackend.enums.EnumStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSaveRequestDTO {
    private String name;
    private String description;
    private Double price;
    private EnumStatus status;
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

}
