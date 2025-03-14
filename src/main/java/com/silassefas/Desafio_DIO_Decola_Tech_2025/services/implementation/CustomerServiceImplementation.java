package com.silassefas.Desafio_DIO_Decola_Tech_2025.services.implementation;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.CustomerRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.CustomerService;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.util.StringNormalizer;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCpfCnpj(StringNormalizer.stringNormalize(customer.getCpfCnpj()));
        customer.setName(StringNormalizer.stringNormalize(customer.getName()));
        if(customer.getCpfCnpj() != null && !customer.getCpfCnpj().trim().isEmpty()){
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
                existingCustomer.setName(StringNormalizer.stringNormalize(customerDateToUpdate.getName()));
            }
            if(customerDateToUpdate.getCustomerType() != null){
                existingCustomer.setCustomerType(customerDateToUpdate.getCustomerType());
            }
            if(customerDateToUpdate.getCpfCnpj() != null && !customerDateToUpdate.getCpfCnpj().trim().isEmpty()){
                existingCustomer.setCpfCnpj(StringNormalizer.stringNormalize(customerDateToUpdate.getCpfCnpj()));
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
    public Customer findByCpfCnpj(String cpfCnpj) {
        Optional<Customer> customer = customerRepository.findCustomerByCpf(StringNormalizer.stringNormalize(cpfCnpj));
        if(customer.isPresent()){
            return customer.get();
        }else
            throw new IllegalArgumentException("Customer not found.");

    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByNameContainingIgnoreCaseAndAccents(String customerName) {
        String normalizedName = org.apache.commons.lang3.StringUtils.stripAccents(customerName);
        return customerRepository.findByNameContainingIgnoreCase(normalizedName);
    }
}
