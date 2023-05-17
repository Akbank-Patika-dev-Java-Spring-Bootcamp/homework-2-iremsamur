package com.akbankbootcamp.ETradeBackend.dao;

import com.akbankbootcamp.ETradeBackend.entity.Product;
import com.akbankbootcamp.ETradeBackend.entity.User;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
