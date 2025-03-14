package com.silassefas.Desafio_DIO_Decola_Tech_2025.services;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;

import java.util.List;

public interface ProductService   {

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product productToUpdate);

    void deleteProduct(Long productId);

    Product findById(Long id);

    List<Product> findByNameContainingIgnoreCaseAndAccents(String productName);

    List<Product> findByCategoryConteningIgnoringCaseAndAccents(String productCategory);

    List<Product> findAll();




}
