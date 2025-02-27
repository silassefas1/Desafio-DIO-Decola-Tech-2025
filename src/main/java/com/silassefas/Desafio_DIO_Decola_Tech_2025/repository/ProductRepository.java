package com.silassefas.Desafio_DIO_Decola_Tech_2025.repository;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoryContainingIgnoreCase(String category);

}
