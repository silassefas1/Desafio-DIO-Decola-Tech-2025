package com.silassefas.Desafio_DIO_Decola_Tech_2025.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String category;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm Z")
    private ZonedDateTime createdAt;


    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm Z")
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;

    }


    

}
