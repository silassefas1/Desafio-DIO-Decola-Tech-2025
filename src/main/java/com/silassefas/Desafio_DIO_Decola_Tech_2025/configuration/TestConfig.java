package com.silassefas.Desafio_DIO_Decola_Tech_2025.configuration;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.ProductRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.List;

public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    /*Para testar a aplicação iniciando ela com alguns produtos cadastrados eu fiz essa classe pois criando um arquivo data sql
    estava dando erro na hora de criar a tabela no banco de dados. Acredito que essa tenha sido a solução mais pratica*/
    public void run(String... args) throws Exception {

        // Produtos de Computadores
        Product productTest1 = new Product(null, "Computador 1 - Macbook Pro", "Computador portátil da Apple com chip M1, 16GB de RAM e tela de 13 polegadas.", new BigDecimal("1250.0"), "Computadores");
        Product productTest2 = new Product(null, "Computador 2 - Dell XPS 13", "Notebook da Dell com processador Intel i7, 16GB de RAM e tela de 13.4 polegadas.", new BigDecimal("1150.0"), "Computadores");
        Product productTest3 = new Product(null, "Computador 3 - Microsoft Surface Laptop 4", "Laptop da Microsoft com tela de 13.5 polegadas, Intel Core i7 e 16GB de RAM.", new BigDecimal("1349.99"), "Computadores");
        Product productTest4 = new Product(null, "Computador 4 - Lenovo ThinkPad X1 Carbon", "Notebook da Lenovo com tela de 14 polegadas, Intel i7, 16GB de RAM e 512GB SSD.", new BigDecimal("1799.99"), "Computadores");
        Product productTest5 = new Product(null, "Computador 5 - Asus ROG Zephyrus G14", "Laptop gamer da ASUS com processador AMD Ryzen 9, 16GB de RAM e GPU NVIDIA RTX 3060.", new BigDecimal("1499.99"), "Computadores");

        // Produtos de Smartphones
        Product productTest6 = new Product(null, "Smartphone 1 - iPhone 13", "Smartphone da Apple com tela de 6.1 polegadas, 128GB de armazenamento e câmera de 12MP.", new BigDecimal("999.99"), "Smartphones");
        Product productTest7 = new Product(null, "Smartphone 2 - Samsung Galaxy S21", "Smartphone da Samsung com tela de 6.2 polegadas, 8GB de RAM e 128GB de armazenamento.", new BigDecimal("849.99"), "Smartphones");
        Product productTest8 = new Product(null, "Smartphone 3 - Google Pixel 6", "Smartphone do Google com tela de 6.4 polegadas, 8GB de RAM e câmera de 50MP.", new BigDecimal("599.99"), "Smartphones");
        Product productTest9 = new Product(null, "Smartphone 4 - Xiaomi Mi 11", "Smartphone da Xiaomi com tela de 6.81 polegadas, Snapdragon 888 e 128GB de armazenamento.", new BigDecimal("749.99"), "Smartphones");
        Product productTest10 = new Product(null, "Smartphone 5 - OnePlus 9 Pro", "Smartphone da OnePlus com tela de 6.7 polegadas, Snapdragon 888 e 256GB de armazenamento.", new BigDecimal("1069.99"), "Smartphones");
        Product productTest11 = new Product(null, "Smartphone 6 - Samsung Galaxy Z Fold 3", "Celular dobrável da Samsung com tela de 7.6 polegadas, 12GB de RAM e 256GB de armazenamento.", new BigDecimal("1799.99"), "Smartphones");

        // Acessórios para Computadores
        Product productTest12 = new Product(null, "Acessório Computador 1 - Logitech MX Master 3", "Mouse ergonômico sem fio da Logitech com alta precisão e 70 horas de bateria.", new BigDecimal("99.99"), "Acessórios de Computadores");
        Product productTest13 = new Product(null, "Acessório Computador 2 - Razer DeathAdder Elite", "Mouse gamer da Razer com 16,000 DPI, design ergonômico e retroiluminação RGB.", new BigDecimal("69.99"), "Acessórios de Computadores");
        Product productTest14 = new Product(null, "Acessório Computador 3 - Corsair Vengeance LPX 16GB", "Memória RAM Corsair DDR4 de 16GB, com alta performance e compatibilidade com plataformas AMD e Intel.", new BigDecimal("79.99"), "Acessórios de Computadores");
        Product productTest15 = new Product(null, "Acessório Computador 4 - NVIDIA GeForce RTX 3080", "Placa de vídeo NVIDIA GeForce RTX 3080, ideal para jogos em 4K e criação de conteúdo.", new BigDecimal("699.99"), "Acessórios de Computadores");
        Product productTest16 = new Product(null, "Acessório Computador 5 - Samsung 970 EVO Plus 1TB", "SSD Samsung 970 EVO Plus com 1TB de armazenamento e velocidade de leitura de até 3500 MB/s.", new BigDecimal("129.99"), "Acessórios de Computadores");
        Product productTest17 = new Product(null, "Acessório Computador 6 - Seagate Expansion 2TB", "HD externo Seagate de 2TB, ideal para backups e armazenamento de dados.", new BigDecimal("69.99"), "Acessórios de Computadores");
        Product productTest18 = new Product(null, "Acessório Computador 7 - HyperX Alloy FPS Pro", "Teclado mecânico compacto da HyperX, com switches mecânicos e retroiluminação RGB.", new BigDecimal("89.99"), "Acessórios de Computadores");
        Product productTest19 = new Product(null, "Acessório Computador 8 - Corsair K95 RGB Platinum", "Teclado mecânico Corsair com switches Cherry MX e retroiluminação RGB.", new BigDecimal("199.99"), "Acessórios de Computadores");

        // Acessórios para Smartphones
        Product productTest20 = new Product(null, "Acessório Smartphone 1 - Apple AirPods Pro", "Fones de ouvido sem fio da Apple com cancelamento de ruído e modo ambiente.", new BigDecimal("249.99"), "Acessórios de Smartphones");
        Product productTest21 = new Product(null, "Acessório Smartphone 2 - Sony WH-1000XM4", "Fones de ouvido sem fio com cancelamento de ruído ativo e até 30 horas de bateria.", new BigDecimal("350.0"), "Acessórios de Smartphones");
        Product productTest22 = new Product(null, "Acessório Smartphone 3 - Apple Watch Series 7", "Relógio inteligente da Apple com monitoramento de saúde, tela de retina e resistência à água.", new BigDecimal("399.99"), "Acessórios de Smartphones");
        Product productTest23 = new Product(null, "Acessório Smartphone 4 - Apple MagSafe Charger", "Carregador sem fio MagSafe para iPhone e dispositivos Apple com carregamento rápido.", new BigDecimal("39.99"), "Acessórios de Smartphones");
        Product productTest24 = new Product(null, "Acessório Smartphone 5 - Anker PowerCore 10000", "Power bank Anker com 10,000mAh, ideal para carregar dispositivos móveis em movimento.", new BigDecimal("24.99"), "Acessórios de Smartphones");
        Product productTest25 = new Product(null, "Acessório Smartphone 6 - Bose QuietComfort 35 II", "Fones de ouvido Bose com cancelamento de ruído ativo e som de alta qualidade.", new BigDecimal("299.99"), "Acessórios de Smartphones");
        Product productTest26 = new Product(null, "Acessório Smartphone 7 - Baseus Magnetic Wireless Charger", "Carregador sem fio magnético para iPhone com 15W de potência.", new BigDecimal("49.99"), "Acessórios de Smartphones");
        Product productTest27 = new Product(null, "Acessório Smartphone 8 - JBL Charge 4", "Caixa de som Bluetooth JBL com resistência à água e até 20 horas de reprodução.", new BigDecimal("129.99"), "Acessórios de Smartphones");
        Product productTest28 = new Product(null, "Acessório Smartphone 9 - Apple AirPods Max", "Fones de ouvido over-ear da Apple com cancelamento de ruído e som de alta fidelidade.", new BigDecimal("549.99"), "Acessórios de Smartphones");
        Product productTest29 = new Product(null, "Acessório Smartphone 10 - Samsung 970 EVO Plus 1TB", "SSD Samsung 970 EVO Plus com 1TB de armazenamento e velocidade de leitura de até 3500 MB/s.", new BigDecimal("129.99"), "Acessórios de Smartphones");
        Product productTest30 = new Product(null, "Acessório Smartphone 11 - Samsung Galaxy Tab S7", "Tablet da Samsung com tela de 11 polegadas, 128GB de armazenamento e S Pen.", new BigDecimal("649.99"), "Acessórios de Smartphones");


        productRepository.saveAll(List.of(productTest1, productTest2, productTest3, productTest4, productTest5, productTest6, productTest7, productTest8, productTest9, productTest10, productTest11, productTest12, productTest13, productTest14, productTest15, productTest16, productTest17, productTest18, productTest19, productTest20));

    }
}
