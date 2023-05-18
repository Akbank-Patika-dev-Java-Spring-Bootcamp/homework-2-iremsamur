package com.akbankbootcamp.ETradeBackend.controller.contract.impl;

import com.akbankbootcamp.ETradeBackend.controller.contract.ProductControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.mapper.ProductMapper;
import com.akbankbootcamp.ETradeBackend.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {
    private final ProductEntityService productEntityService;
    @Autowired
    public ProductControllerContractImpl(ProductEntityService productEntityService) {
        this.productEntityService = productEntityService;
    }

    @Override
    public ProductDTO add(ProductSaveRequestDTO request) {
        Product product = ProductMapper.INSTANCE.convertToProduct(request);
        product = productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public ProductDTO update(Double productPrice,Long productId) {
        Product product = productEntityService.findById(productId).orElse(null);
        product.setPrice(productPrice);
        product = productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductMapper.INSTANCE.convertToProductDTOList(productList);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productEntityService.findById(id).orElse(null);
        return ProductMapper.INSTANCE.convertToProductDTO(product);
    }

    @Override
    public void delete(Long id) {
        productEntityService.delete(id);
    }
}
