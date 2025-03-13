package com.silassefas.Desafio_DIO_Decola_Tech_2025.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("PENDING"),
    PAID("PAID"),
    REFUNDED("REFUNDED");

    private final String value;

    PaymentStatus(String value){
        this.value = value;
    }
    public static PaymentStatus fromValue(String value){
        for(PaymentStatus type: PaymentStatus.values()){
            if(type.getValue().equals(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }

}
