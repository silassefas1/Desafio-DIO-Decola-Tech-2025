package com.silassefas.Desafio_DIO_Decola_Tech_2025.model;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.OrderStatus;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Customer;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // PENDING, CONFIRMED, CANCELED

    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> products = new HashMap<>();

    private BigDecimal totalValue;
}
