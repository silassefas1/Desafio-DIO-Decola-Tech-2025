package com.silassefas.Desafio_DIO_Decola_Tech_2025.services;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customerDateToUpdate);

    Customer deleteCustomer(Long customerId);

    Customer findById(Long id);

    Customer findCustomerByCpfCnpj(String cpf);

    List<Customer> findAll();

    List<Customer> findByNameContainingIgnoreCaseAndAccents(String customerName);

}
