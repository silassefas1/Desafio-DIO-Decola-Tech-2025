package com.silassefas.Desafio_DIO_Decola_Tech_2025.controller;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
       return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Customer> findByCnpj(@PathVariable String cnpj){
        return ResponseEntity.ok(customerService.findByCnpj(cnpj));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Customer> findByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(customerService.findByCpf(cpf));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> findByNameContainingIgnoreCase(String customerName){
        return ResponseEntity.ok(customerService.findByNameContainingIgnoreCaseAndAccents(customerName));
    }
}
