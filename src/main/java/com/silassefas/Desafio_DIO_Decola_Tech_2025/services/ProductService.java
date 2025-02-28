package com.silassefas.Desafio_DIO_Decola_Tech_2025.services;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductService   {

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product productToUpdate);

    Product deleteProduct(Long productId);

    Product findById(Long id);

    List<Product> findByNameContainingIgnoreCase(String productName);

    List<Product> findByCategoryContainingIgnoreCase(String productCategory);

    List<Product> findAll();




}
