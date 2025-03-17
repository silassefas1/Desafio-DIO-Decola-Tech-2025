package com.silassefas.Desafio_DIO_Decola_Tech_2025.model;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.CustomerType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_customer")
@EqualsAndHashCode
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

    @Column(unique = true)
    private String cpfCnpj;

    private String email;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
    private ZonedDateTime registrationDate;


    public Customer(){
        this.registrationDate = ZonedDateTime.now();
    }

    public Customer(Long id, String name, CustomerType customerType, String cpfCnpj, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.customerType = customerType;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = ZonedDateTime.now();
        this.orders = new ArrayList<>();

    }
}
