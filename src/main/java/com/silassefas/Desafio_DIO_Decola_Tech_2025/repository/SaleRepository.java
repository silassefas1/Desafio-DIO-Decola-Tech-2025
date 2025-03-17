package com.silassefas.Desafio_DIO_Decola_Tech_2025.repository;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByOrderCustomerNameContainingIgnoreCase(String name);
}
