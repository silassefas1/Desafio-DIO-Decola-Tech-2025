package com.silassefas.Desafio_DIO_Decola_Tech_2025.services.implementation;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.CustomerRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String stringNormalize(String stringToNormalize){
        if(stringToNormalize == null){
            throw new IllegalArgumentException("Value can't be null");
        }else {
            return stringToNormalize.replaceAll("[/.^~´`-]", "");
        }

    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setRegistrationDate(java.time.ZonedDateTime.now());
        customer.setCnpj(stringNormalize(customer.getCnpj()));
        customer.setCpf(stringNormalize(customer.getCpf()));
        customer.setName(stringNormalize(customer.getName()));
        if(customer.getCpf() != null && !customer.getCpf().trim().isEmpty() || customer.getCnpj() != null && !customer.getCnpj().trim().isEmpty()){
           return customerRepository.save(customer);
        }else
            throw new IllegalArgumentException("CPF or CNPJ cannot be null or empty.");
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customerDateToUpdate) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            if(customerDateToUpdate.getName() != null && !customerDateToUpdate.getName().trim().isEmpty()){
                existingCustomer.setName(stringNormalize(customerDateToUpdate.getName()));
            }
            if(customerDateToUpdate.getCustomerType() != null){
                existingCustomer.setCustomerType(customerDateToUpdate.getCustomerType());
            }
            if(customerDateToUpdate.getCpf() != null && !customerDateToUpdate.getCpf().trim().isEmpty()){
                existingCustomer.setCpf(stringNormalize(customerDateToUpdate.getCpf()));
            }
            if(customerDateToUpdate.getCnpj() != null && !customerDateToUpdate.getCnpj().trim().isEmpty()){
                existingCustomer.setCnpj(stringNormalize(customerDateToUpdate.getCnpj()));
            }
            if(customerDateToUpdate.getEmail() != null && !customerDateToUpdate.getEmail().trim().isEmpty()){
                existingCustomer.setEmail(customerDateToUpdate.getEmail());
            }
            if(customerDateToUpdate.getPhone() != null && !customerDateToUpdate.getPhone().trim().isEmpty()){
                existingCustomer.setPhone(customerDateToUpdate.getPhone());
            }
            if(customerDateToUpdate.getAddress() != null && !customerDateToUpdate.getAddress().trim().isEmpty()){
                existingCustomer.setAddress(customerDateToUpdate.getAddress());
            }
            customerRepository.save(existingCustomer);
            return customer.get();
        } else
            throw new IllegalArgumentException("Customer not found.");

    }

    @Override
    public Customer deleteCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            return customer.get();
        } else
            throw new IllegalArgumentException("Customer not found.");
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Customer with id "+ id+ " not found"));
    }


    @Override
    public Customer findByCpf(String cpf) {
        Optional<Customer> customer = customerRepository.findCustomerByCpf(stringNormalize(cpf));
        if(customer.isPresent()){
            return customer.get();
        }else
            throw new IllegalArgumentException("Customer not found.");

    }

    @Override
    public Customer findByCnpj(String cnpj) {
        Optional<Customer> customer = customerRepository.findCustomerByCnpj(stringNormalize(cnpj));
        if(customer.isPresent()){
            return customer.get();
        }else
            throw new IllegalArgumentException("Customer not found.");

    }

    @Override
    public List<Customer> findByNameContainingIgnoreCaseAndAccents(String customerName) {
        String normalizedName = org.apache.commons.lang3.StringUtils.stripAccents(customerName);
        return customerRepository.findByNameContainingIgnoreCase(normalizedName);
    }
}
