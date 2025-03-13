package com.silassefas.Desafio_DIO_Decola_Tech_2025.repository;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.cnpj = :cnpj")
    Optional<Customer> findCustomerByCnpj(String cnpj);

    @Query("SELECT c FROM Customer c WHERE c.cpf = :cpf")
    Optional<Customer> findCustomerByCpf(String cpf);

    List<Customer> findByNameContainingIgnoreCase(String customerName);
}
