package com.silassefas.Desafio_DIO_Decola_Tech_2025.enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    SALE("SALE"),
    PUNCHASE("PUNCHASE"),
    EXPENSE("EXPENSE"),
    REFUND("REFUND");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    public static TransactionType fromValue(String value) {
        for (TransactionType type : TransactionType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de transação inválido: " + value);
    }
}
