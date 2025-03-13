package com.silassefas.Desafio_DIO_Decola_Tech_2025.model;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CustomerType customerType;

    @Column(unique = true)
    private String cnpj;

    @Column(unique = true)
    private String cpf;
    private String email;
    private String phone;
    private String address;
    private ZonedDateTime registrationDate;


    public Customer(){
    }

    public Customer(Long id, String name, CustomerType customerType, String cnpj, String cpf, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.customerType = customerType;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = ZonedDateTime.now();

    }
}
