package com.silassefas.Desafio_DIO_Decola_Tech_2025.services.implementation;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.ProductRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(java.time.LocalDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productToUpdate) {
        Optional<Product> existentProduct = productRepository.findById(productId);
        if (existentProduct.isPresent()) {
            Product product = existentProduct.get();
            if(productToUpdate.getName() != null && !productToUpdate.getName().trim().isEmpty()) {
                product.setName(productToUpdate.getName());
            }
            if(productToUpdate.getPrice() != null && productToUpdate.getPrice().compareTo(java.math.BigDecimal.ZERO) > 0) {
                product.setPrice(productToUpdate.getPrice());
            }
            if(productToUpdate.getDescription() != null && !productToUpdate.getDescription().trim().isEmpty()) {
                product.setDescription(productToUpdate.getDescription());
            }
            if(productToUpdate.getCategory() != null && !productToUpdate.getCategory().trim().isEmpty()) {
                product.setCategory(productToUpdate.getCategory());
            }
            product.setUpdatedAt(java.time.LocalDateTime.now());
            return productRepository.save(product);

        }else{
            throw new NoSuchElementException("Product with ID " + productId + " not found.");
        }


    }

    @Override
    public Product deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
            return product.get();
        }else{
            throw new NoSuchElementException("Product with ID " + productId + " not found.");
        }

    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String productName) {
        return productRepository.findByNameContainingIgnoreCase(productName);
    }

    @Override
    public List<Product> findByCategoryContainingIgnoreCase(String productCategory) {
        return productRepository.findByCategoryContainingIgnoreCase(productCategory);
    }
    
}
