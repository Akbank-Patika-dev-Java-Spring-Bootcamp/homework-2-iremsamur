package com.akbankbootcamp.ETradeBackend.service.entityservice;

import com.akbankbootcamp.ETradeBackend.dao.ProductRepository;
import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {

    private ProductRepository repository;

    @Autowired
    public ProductEntityService(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
