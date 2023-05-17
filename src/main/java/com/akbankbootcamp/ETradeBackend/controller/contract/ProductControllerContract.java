package com.akbankbootcamp.ETradeBackend.controller.contract;

import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;

import java.util.List;

public interface ProductControllerContract {
    ProductDTO add(ProductSaveRequestDTO request);
    ProductDTO update(Double productPrice,Long productId);

    List<ProductDTO> findAll();
    ProductDTO getById(Long id);

    void delete(Long id);
}
