package com.silassefas.Desafio_DIO_Decola_Tech_2025.model;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.PaymentStatus;
import lombok.*;
import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; // PENDING, PAID, REFUNDED

    private ZonedDateTime saleDate;
}
