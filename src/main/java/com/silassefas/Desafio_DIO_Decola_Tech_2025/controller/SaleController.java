package com.silassefas.Desafio_DIO_Decola_Tech_2025.controller;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Sale;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/{saleId}/finalize")
    public Sale finalizeSale(@PathVariable Long saleId) {
        return saleService.finalizeSale(saleId);
    }

    @PostMapping("/{saleId}/cancel")
    public Sale cancelSale(@PathVariable Long saleId) {
        return saleService.cancelSale(saleId);
    }

    @GetMapping("/customer/{customerName}")
    public List<Sale> getSalesByCustomer(@PathVariable String customerName) {
        return saleService.findSalesByCustomerName(customerName);
    }
}
