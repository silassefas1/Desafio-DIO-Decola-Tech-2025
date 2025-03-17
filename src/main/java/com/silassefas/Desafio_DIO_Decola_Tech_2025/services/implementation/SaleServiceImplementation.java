package com.silassefas.Desafio_DIO_Decola_Tech_2025.services.implementation;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.enums.PaymentStatus;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Sale;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.SaleRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class SaleServiceImplementation implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale finalizeSale(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        if (sale.getPaymentStatus() != PaymentStatus.PENDING) {
            throw new RuntimeException("Venda já foi processada");
        }

        sale.setPaymentStatus(PaymentStatus.PAID);
        return saleRepository.save(sale);
    }

    @Override
    public Sale cancelSale(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        if (sale.getPaymentStatus() == PaymentStatus.PAID) {
            throw new RuntimeException("Venda já foi paga e não pode ser cancelada diretamente");
        }

        sale.setPaymentStatus(PaymentStatus.REFUNDED);
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> findSalesByCustomerName(String customerName) {
        return saleRepository.findByOrderCustomerNameContainingIgnoreCase(customerName);
    }
}
