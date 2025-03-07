# 🌟 Desafio-DIO-Decola-Tech-2025

Este projeto consiste no desenvolvimento de uma API para o gerenciamento de uma loja de eletrônicos e serviços de assistência técnica. A solução permitirá um controle eficiente de produtos, estoque, vendas, ordens de serviço e atendimento ao cliente, proporcionando uma gestão integrada e otimizada para o negócio. 🛒💻

## 📜 Descrição do Projeto

A API permitirá a gestão de produtos, controle de estoque, processamento de pedidos e outras funcionalidades essenciais para o funcionamento eficiente de uma loja de eletrônicos, proporcionando uma experiência aprimorada para os usuários e facilitando a operação do negócio. 🚀

## 📊 Diagrama de Classes

Abaixo está o diagrama de classes que representa a estrutura do projeto e as relações entre as entidades:

```mermaid
classDiagram
    class Product {
        - Long id
        - String name
        - String description
        - BigDecimal price
        - String category
        - ZonedDateTime createdAt
        - ZonedDateTime updatedAt
        + void createProduct()
        + void updateProduct()
        + void deleteProduct()
        + Product findById(Long id)
        + List<Product> findByNameContainingIgnoreCaseAndAccents(String name)
        + List<Product> findAll()
        + List<Product> findByCategoryContainingIgnoringCaseAndAccents(String category)
    }
    
    class Stock {
        - Long id
        - Product product
        - Integer availableQuantity
        - Integer minStock
        + void updateStock()
        + boolean checkMinimumStock()
    }
    
    class StockMovement {
        - Long id
        - Product product
        - MovementType movementType
        - Integer quantity
        - ZonedDateTime movementDate
        + void registerEntry()
        + void registerExit()
        + void adjustMovement()
    }
    
    class Order {
        - Long id
        - Customer customer
        - ZonedDateTime orderDate
        - List<OrderItem> items
        - BigDecimal totalValue
        - OrderStatus status
        + void addItem(OrderItem item)
        + void removeItem(OrderItem item)
        + BigDecimal calculateTotalValue()
        + void confirmOrder()
        + void cancelOrder()
    }
    
    class OrderItem {
        - Long id
        - Order order
        - Product product
        - Integer quantity
        - BigDecimal unitPrice
        - BigDecimal subtotal
    }
    
    class Sale {
        - Long id
        - Order order
        - ZonedDateTime saleDate
        - Payment payment
        + void finalizeSale()
        + void cancelSale()
    }
    
    class Payment {
        - Long id
        - Sale sale
        - PaymentMethod paymentMethod
        - PaymentStatus paymentStatus
        - BigDecimal amountPaid
        + void processPayment()
    }
    
    class Customer {
        - Long id
        - String name
        - CustomerType customerType
        - String cnpjCpf
        - String rgCnh
        - String email
        - String phone
        - String address
        - ZonedDateTime registrationDate
        - List<Sale> purchaseHistory
        + void registerCustomer()
        + void updateCustomer()
        + void deleteCustomer()
        + Customer findById(Long id)
        + List<Customer> listCustomers()
    }
    
    class Revenue {
        - Long id
        - String description
        - BigDecimal amount
        - ZonedDateTime receiptDate
        + void createRevenue()
    }
    
    class Expense {
        - Long id
        - String description
        - BigDecimal amount
        - ZonedDateTime paymentDate
        + void createExpense()
    }
    
    class FinancialTransaction {
        - Long id
        - TransactionType transactionType  
        - BigDecimal amount
        - ZonedDateTime transactionDate
        - String description 
        + void registerTransaction()
    }
    
    class CashFlow {
        - Long id
        - BigDecimal currentBalance
        - List<FinancialTransaction> transactions 
        + BigDecimal checkBalance()
        + void addSaleTransaction(Sale sale)
        + void addExpenseTransaction(Expense expense)
        + void updateBalance()
    }
    
    class Invoice {
        - Long id
        - Sale sale
        - ZonedDateTime issueDate
        - BigDecimal totalValue
        - BigDecimal taxes
        - InvoiceStatus invoiceStatus
        - ZonedDateTime dueDate
        + void createInvoice()
        + void updateInvoice()
        + void cancelInvoice()
        + Invoice findById(Long id)
        + List<Invoice> listInvoices()
    }
    
    class Purchase {
        - Long id
        - Supplier supplier
        - ZonedDateTime purchaseDate
        - BigDecimal totalValue
        - PurchaseStatus status
        - String notes
        - List<Product> products
        + void createPurchase()
        + void updatePurchaseStatus()
        + BigDecimal calculateTotalValue()
        + List<Purchase> listPurchases()
        + Purchase findById(Long id)
    }
    
    class Supplier {
        - Long id
        - String name
        - String contact
        - String address
        - List<Product> offeredProducts
        - List<Purchase> purchaseHistory
        + void registerSupplier()
        + void updateSupplier()
        + void deleteSupplier()
        + List<Supplier> listSuppliers()
        + Supplier findById(Long id)
    }
    
  %%' ---------------------------
  %%' Relacionamentos
  %%' ---------------------------
    Order "1" -- "*" OrderItem 
    Order "1" --> "1" Customer 
    Order "1" --> "1" Sale 
    Sale "1" --> "1" Payment 
    OrderItem "*" --> "1" Product 
    Revenue "1" --> "1" Sale 
    Expense "1" --> "1" Purchase 
    CashFlow "1" -- "*" FinancialTransaction 
    Invoice "1" --> "1" Sale 
    Purchase "1" --> "1" Supplier 
    Purchase "1" -- "*" Product 
    Stock "1" -- "*" StockMovement 
    StockMovement "1" --> "1" Product 
    Sale "1" -- "*" StockMovement 
    
    %%' ---------------------------
    %%' Enums Necessários
    %%' ---------------------------


    class CustomerType {
        <<enumeration>>
        + INDIVIDUAL
        + CORPORATE
    }
    
    class PaymentMethod {
        <<enumeration>>
        + CASH
        + CREDIT_CARD
        + DEBIT_CARD
        + BANK_TRANSFER
        + OTHER
    }
    
    class OrderStatus {
        <<enumeration>>
        + PENDING
        + CONFIRMED
        + CANCELLED
        + COMPLETED
    }
    
    class PaymentStatus {
        <<enumeration>>
        + PENDING
        + COMPLETED
        + FAILED
    }


```
## ✅ Funcionalidades
🏷️ Cadastro e gerenciamento de produtos     
📦 Controle de estoque   
📝 Processamento de pedidos   
👥 Gerenciamento de clientes    
💰 Registro de movimentações financeiras  
📄 Emissão de faturas 

## 🚀 Padrões de Commits

Adotado os seguintes prefixos para descrever o propósito de cada commit:

✨ feat: Nova funcionalidade.<br>
🐛 fix: Correção de bugs. <br>
📝 docs: Alterações na documentação.<br>
💅 style: Mudanças que não afetam a lógica do código (formatação, espaços, etc.).<br>
🔨 refactor: Melhorias na estrutura do código sem adicionar funcionalidades ou corrigir bugs.<br>
✅ test: Adição ou modificação de testes.<br>
🧹 chore: Tarefas de manutenção (configurações, dependências, etc.)<br>

## 📄 Licença  
Este projeto é licenciado sob a **Licença de Uso Não Comercial e Sem Alterações**. Você pode usar, copiar e distribuir o código-fonte e a documentação associados a este software exclusivamente para **fins de estudo**, desde que faça isso de forma não comercial. Para mais informações, consulte o arquivo LICENSE.

## 👤 Sobre o Autor

🔧 **Desenvolvedor:** Silas Sefas de Souza Aquino  
🌐 **LinkedIn:** [silassefas](https://www.linkedin.com/in/silassefas/)  
:octocat: **GitHub:** [silassefas1](https://github.com/silassefas1)
Sinta-se à vontade para me conectar nas redes sociais! Estou sempre aberto a novas oportunidades e colaborações. 🚀


## ⚠ Aviso

Este projeto é de caráter **educacional** e está em constante desenvolvimento.  
Mudanças significativas podem ocorrer ao longo do tempo, incluindo ajustes na estrutura, funcionalidades e até mesmo na tecnologia utilizada.

Sinta-se à vontade para contribuir e melhorar o projeto! Quaisquer sugestões ou colaborações são bem-vindas. 😊  
