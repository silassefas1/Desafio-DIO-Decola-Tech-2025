package com.silassefas.Desafio_DIO_Decola_Tech_2025.configuration;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.CustomerType;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    /* Para testar a aplicação iniciando-a com alguns cadastras, eu fiz esta classe, pois criar um arquivo data.sql
    estava dando erro na hora de criar a tabela no banco de dados. Acredito que esta tenha sido a solução mais prática */
    public void run(String... args) {

        Customer customerTest1 = new Customer(null, "Joao da Silva", CustomerType.INDIVIDUAL, "12345678900", "joao.silva@example.com", "(21) 99876-5432", "Rua das Flores, 123, Rio de Janeiro, RJ, Brasil");
        Customer customerTest2 = new Customer(null, "Maria Santos", CustomerType.INDIVIDUAL, "23456789011", "maria.santos@example.com", "(11) 98765-4321", "Av. Paulista, 456, São Paulo, SP, Brasil");
        Customer customerTest3 = new Customer(null, "Tech Innovators Ltd.", CustomerType.BUSINESS, "34567890000177", "contact@techinnovators.com", "(31) 94567-8901", "Rua dos Três Irmãos, 789, Belo Horizonte, MG, Brasil");
        Customer customerTest4 = new Customer(null, "Global Solutions Inc.", CustomerType.BUSINESS, "45678901000166", "info@globalsolutions.com", "(71) 96321-4321", "Rua do Comércio, 1011, Salvador, BA, Brasil");
        customerRepository.saveAll(List.of(customerTest1, customerTest2, customerTest3, customerTest4)); customerRepository.saveAll(List.of(customerTest1, customerTest2,customerTest3,customerTest4));

    }
}
