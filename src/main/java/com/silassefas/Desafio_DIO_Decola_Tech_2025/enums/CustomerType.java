package com.silassefas.Desafio_DIO_Decola_Tech_2025.enums;

import lombok.Getter;

@Getter
public enum CustomerType {
    INDIVIDUAL("INDIVIDUAL"),
    BUSINESS("BUSINESS");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }

    public static CustomerType fromValue(String value) {
        for (CustomerType type : CustomerType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }
}
