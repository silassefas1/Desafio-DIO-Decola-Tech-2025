package com.silassefas.Desafio_DIO_Decola_Tech_2025.configuration;

import com.silassefas.Desafio_DIO_Decola_Tech_2025.model.Product;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.repository.ProductRepository;
import com.silassefas.Desafio_DIO_Decola_Tech_2025.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    /*Para testar a aplicação iniciando ela com alguns produtos cadastrados eu fiz essa classe pois criando um arquivo data sql
    estava dando erro na hora de criar a tabela no banco de dados. Acredito que essa tenha sido a solução mais pratica*/
    public void run(String... args) throws Exception {

        Product productTest1 = new Product(null, "Apple MacBook Pro 13", "Notebook da Apple com chip M1, 16GB de RAM e tela Retina de 13,3 polegadas.", new BigDecimal("11999.00"), "Computadores");
        Product productTest2 = new Product(null, "Dell XPS 13", "Notebook da Dell com processador Intel Core i7 de 12ª geração, 16GB de RAM e SSD de 512GB.", new BigDecimal("8799.00"), "Computadores");
        Product productTest3 = new Product(null, "Microsoft Surface Laptop 4", "Notebook da Microsoft com tela de 13,5 polegadas, processador Intel Core i7 e 16GB de RAM.", new BigDecimal("10299.00"), "Computadores");
        Product productTest4 = new Product(null, "Lenovo ThinkPad X1 Carbon", "Notebook Lenovo ThinkPad X1 Carbon Gen 9, tela de 14 polegadas, Intel Core i7, 16GB de RAM e SSD de 1TB.", new BigDecimal("11899.00"), "Computadores");
        Product productTest5 = new Product(null, "Asus ROG Zephyrus G14", "Notebook gamer da ASUS com processador AMD Ryzen 9 6900HS, 32GB de RAM e GPU NVIDIA RTX 3060.", new BigDecimal("13299.00"), "Computadores");

        Product productTest6 = new Product(null, "Apple iPhone 13", "Smartphone da Apple com tela Super Retina XDR de 6,1 polegadas, chip A15 Bionic, 128GB de armazenamento e câmera dupla de 12MP.", new BigDecimal("4699.00"), "Smartphones");
        Product productTest7 = new Product(null, "Samsung Galaxy S21", "Smartphone Samsung com tela Dynamic AMOLED 2X de 6,2 polegadas, 8GB de RAM e 128GB de armazenamento.", new BigDecimal("3799.00"), "Smartphones");
        Product productTest8 = new Product(null, "Google Pixel 6", "Smartphone do Google com tela OLED de 6,4 polegadas, processador Google Tensor e câmera de 50MP.", new BigDecimal("3199.00"), "Smartphones");
        Product productTest9 = new Product(null, "Xiaomi Mi 11", "Smartphone Xiaomi com tela AMOLED de 6,81 polegadas, Snapdragon 888, 8GB de RAM e câmera de 108MP.", new BigDecimal("3899.00"), "Smartphones");
        Product productTest10 = new Product(null, "OnePlus 9 Pro", "Smartphone OnePlus com tela AMOLED de 6,7 polegadas, Snapdragon 888, 12GB de RAM e câmera Hasselblad de 48MP.", new BigDecimal("4799.00"), "Smartphones");
        Product productTest11 = new Product(null, "Samsung Galaxy Z Fold 3", "Smartphone dobrável da Samsung com tela principal de 7,6 polegadas, 12GB de RAM e 512GB de armazenamento.", new BigDecimal("8999.00"), "Smartphones");

        Product productTest12 = new Product(null, "Mouse Logitech MX Master 3", "Mouse sem fio ergonômico da Logitech com sensor de alta precisão e autonomia de 70 horas.", new BigDecimal("599.00"), "Acessórios para Computador");
        Product productTest13 = new Product(null, "Mouse Gamer Razer DeathAdder Elite", "Mouse gamer da Razer com sensor óptico de 16.000 DPI, design ergonômico e iluminação RGB.", new BigDecimal("299.00"), "Acessórios para Computador");
        Product productTest14 = new Product(null, "Memória RAM Corsair Vengeance LPX 16GB", "Módulo de memória RAM Corsair DDR4 de 16GB, 3200MHz, compatível com AMD e Intel.", new BigDecimal("499.00"), "Acessórios para Computador");
        Product productTest15 = new Product(null, "Placa de Vídeo NVIDIA GeForce RTX 3080", "Placa de vídeo NVIDIA GeForce RTX 3080 com 10GB GDDR6X, ideal para jogos em 4K.", new BigDecimal("3999.00"), "Acessórios para Computador");
        Product productTest16 = new Product(null, "SSD NVMe Samsung 970 EVO Plus 1TB", "SSD NVMe da Samsung com 1TB de armazenamento, velocidades de leitura de até 3500MB/s.", new BigDecimal("799.00"), "Acessórios para Computador");
        Product productTest17 = new Product(null, "Teclado Mecânico HyperX Alloy FPS Pro", "Teclado mecânico compacto da HyperX com switches mecânicos e iluminação RGB.", new BigDecimal("449.00"), "Acessórios para Computador");

        Product productTest18 = new Product(null, "Fone de Ouvido Apple AirPods Pro", "Fones de ouvido sem fio da Apple com cancelamento ativo de ruído e modo ambiente.", new BigDecimal("1099.00"), "Acessórios para Smartphone");
        Product productTest19 = new Product(null, "Fone de Ouvido Sony WH-1000XM4", "Headphone sem fio da Sony com cancelamento de ruído e bateria de até 30 horas.", new BigDecimal("1499.00"), "Acessórios para Smartphone");
        Product productTest20 = new Product(null, "Carregador MagSafe Apple", "Carregador sem fio MagSafe para iPhones e outros dispositivos compatíveis.", new BigDecimal("349.00"), "Acessórios para Smartphone");
        Product productTest21 = new Product(null, "Power Bank Anker PowerCore 10000", "Carregador portátil da Anker com 10.000mAh de capacidade e tecnologia de carregamento rápido.", new BigDecimal("199.00"), "Acessórios para Smartphone");
        Product productTest22 = new Product(null, "Fone de Ouvido Bose QuietComfort 35 II", "Headphone da Bose com cancelamento ativo de ruído e som de alta qualidade.", new BigDecimal("1399.00"), "Acessórios para Smartphone");
        Product productTest23 = new Product(null, "Carregador sem fio Samsung Wireless Charger Stand", "Carregador rápido sem fio da Samsung compatível com dispositivos Galaxy e outros.", new BigDecimal("229.00"), "Acessórios para Smartphone");
        Product productTest24 = new Product(null, "Capinha Protetora Spigen Rugged Armor", "Capa de proteção para smartphones com design resistente e absorção de impacto.", new BigDecimal("149.00"), "Acessórios para Smartphone");

        Product productTest25 = new Product(null, "Estação Dock Dell USB-C", "Docking station para notebooks com múltiplas conexões, incluindo HDMI e USB-C.", new BigDecimal("999.00"), "Acessórios para Computador");
        Product productTest26 = new Product(null, "Monitor LG UltraFine 4K", "Monitor 4K da LG com alta fidelidade de cores e suporte para HDR10.", new BigDecimal("2999.00"), "Acessórios para Computador");
        Product productTest27 = new Product(null, "HD Externo Western Digital 2TB", "HD externo portátil com 2TB de armazenamento, ideal para backups e armazenamento extra.", new BigDecimal("499.00"), "Acessórios para Computador");
        Product productTest28 = new Product(null, "Headset Gamer SteelSeries Arctis 7", "Headset sem fio para jogos com som de alta qualidade e microfone retrátil.", new BigDecimal("899.00"), "Acessórios para Computador");
        Product productTest29 = new Product(null, "Webcam Logitech C920 HD", "Webcam da Logitech com resolução Full HD, ideal para chamadas de vídeo e streaming.", new BigDecimal("429.00"), "Acessórios para Computador");
        Product productTest30 = new Product(null, "Painel de Controle Elgato Stream Deck", "Controlador personalizável para streamers e criadores de conteúdo, com 15 teclas LCD programáveis.", new BigDecimal("1199.00"), "Acessórios para Computador");

        productRepository.saveAll(List.of(productTest1, productTest2, productTest3, productTest4, productTest5, productTest6, productTest7, productTest8, productTest9, productTest10, productTest11, productTest12, productTest13, productTest14, productTest15, productTest16, productTest17, productTest18, productTest19, productTest20, productTest21, productTest22, productTest23, productTest24, productTest25, productTest26, productTest27, productTest28, productTest29, productTest30));
    }
}
