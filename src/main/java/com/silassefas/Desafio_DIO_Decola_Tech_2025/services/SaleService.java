package com.silassefas.Desafio_DIO_Decola_Tech_2025.services;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Order;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Sale;

import java.util.List;

public interface SaleService  {
    Sale finalizeSale(Long saleId);

    Sale cancelSale(Long saleId);

    List<Sale> findSalesByCustomerName(String customerName);
}
