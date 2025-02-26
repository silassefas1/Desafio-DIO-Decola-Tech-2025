# 🌟 Desafio-DIO-Decola-Tech-2025

Este projeto é baseado em uma ideia que tive há algum tempo e, agora, com o conhecimento adquirido, estou colocando-a em prática. O objetivo deste projeto é desenvolver uma API de gerenciamento para uma loja de eletrônicos e assistência técnica. 🛒💻

## 📜 Descrição do Projeto

A API permitirá a gestão de produtos, controle de estoque, processamento de pedidos e outras funcionalidades essenciais para o funcionamento eficiente de uma loja de eletrônicos, proporcionando uma experiência aprimorada para os usuários e facilitando a operação do negócio. 🚀

## 📊 Diagrama de Classes

Abaixo está o diagrama de classes que representa a estrutura do projeto e as relações entre as entidades:

```mermaid
classDiagram
    class Produto {
        - Long id
        - String nome
        - String descricao
        - BigDecimal preco
        - String categoria
        - LocalDateTime dataCriacao
        - LocalDateTime dataAtualizacao
        + void cadastrar()
        + void atualizar()
        + void remover()
        + Produto buscarPorId(Long id)
        + List<Produto> buscarPorNome(String nome)
        + List<Produto> listar()
        + List<Produto> filtrarPorCategoria(String categoria)
    }
    class Estoque {
        - Long id
        - Produto produto
        - Integer quantidadeDisponivel
        - Integer minEstoque
        + void atualizar()
        + boolean verificarMinimo()
    }
    class MovimentacaoEstoque {
        - Long id
        - Produto produto
        - String tipoMovimentacao
        - Integer quantidade
        - LocalDateTime dataMovimentacao
        + void registrarEntrada()
        + void registrarSaida()
        + void ajustar()
    }
    class Pedido {
        - Long id
        - Cliente cliente
        - LocalDateTime dataPedido
        - List<ItemPedido> itens
        - BigDecimal valorTotal
        - String status
        + void adicionarItem(ItemPedido item)
        + void removerItem(ItemPedido item)
        + BigDecimal calcularValorTotal()
        + void confirmar()
        + void cancelar()
    }
    class Venda {
        - Long id
        - Pedido pedido
        - LocalDateTime dataVenda
        - Pagamento pagamento
        + void finalizar()
        + void cancelar()
    }
    class ItemPedido {
        - Long id
        - Pedido pedido
        - Produto produto
        - Integer quantidade
        - BigDecimal precoUnitario
        - BigDecimal subtotal
    }
    class Pagamento {
        - Long id
        - Venda venda
        - String formaPagamento
        - String statusPagamento
        - BigDecimal valorPago
        + void processarPagamento()
    }
    class Cliente {
        - Long id
        - String nome
        - String tipoCliente
        - String cnpjCpf
        - String rgCnh
        - String email
        - String telefone
        - String endereco
        - LocalDateTime dataCadastro
        - List<Venda> historicoCompras
        + void registrar()
        + void atualizar()
        + void remover()
        + Cliente buscarPorId(Long id)
        + List<Cliente> listar()
    }
    class Receita {
        - Long id
        - String descricao
        - BigDecimal valor
        - LocalDateTime dataRecebimento
        + void registrar()
    }
    class Despesa {
        - Long id
        - String descricao
        - BigDecimal valor
        - LocalDateTime dataPagamento
        + void registrar()
    }
    class TransacaoFinanceira {
        - Long id
        - String tipoTransacao
        - BigDecimal valor
        - LocalDateTime dataTransacao
        - String descricao
        + void registrar()
    }
    class Conta {
        - Long id
        - String tipoConta
        - BigDecimal saldoAtual
        + BigDecimal consultarSaldo()
        + void atualizarSaldo()
    }
    class Fatura {
        - Long id
        - Venda venda
        - LocalDateTime dataEmissao
        - BigDecimal valorTotal
        - BigDecimal impostos
        - String statusFatura
        - LocalDateTime dataVencimento
        + void emitir()
        + void atualizar()
        + void cancelar()
        + Fatura buscarPorId(Long id)
        + List<Fatura> listar()
    }
    class Compra {
        - Long id
        - Fornecedor fornecedor
        - LocalDateTime dataCompra
        - BigDecimal valorTotal
        - String status
        - String notas
        + void registrar()
        + void atualizarStatus()
        + BigDecimal calcularValorTotal()
        + List<Compra> listar()
        + Compra buscarPorId(Long id)
    }
    class Fornecedor {
        - Long id
        - String nome
        - String contato
        - String endereco
        - List<Produto> produtosOfertados
        - List<Compra> historicoCompras
        + void registrar()
        + void atualizar()
        + void remover()
        + List<Fornecedor> listar()
        + Fornecedor buscarPorId(Long id)
    }
    Loja "1" --|> "*" Produto
    Loja "1" --|> "*" Cliente
    Loja "1" --|> "*" Pedido
    Pedido "1" --|> "*" ItemPedido
    Pedido "1" --> "1" Cliente
    Pedido "1" --> "1" Venda
    Venda "1" --> "1" Pagamento
    ItemPedido "*" --> "1" Produto
    Receita "1" --> "1" Venda
    Despesa "1" --> "1" Compra
    Conta "1" --|> "*" TransacaoFinanceira
    Fatura "1" --> "1" Venda
    Compra "1" --> "1" Fornecedor
    Compra "1" --> "*" Produto
    Estoque "1" --|> "*" MovimentacaoEstoque
    MovimentacaoEstoque "1" --> "1" Produto
    Venda "1" --> "*" MovimentacaoEstoque

```
## ✅ Funcionalidades
🏷️ Cadastro e gerenciamento de produtos     
📦 Controle de estoque   
📝 Processamento de pedidos   
👥 Gerenciamento de clientes    
💰 Registro de movimentações financeiras  
📄 Emissão de faturas 

## 📄 Licença  
Este projeto é licenciado sob a **Licença de Uso Não Comercial e Sem Alterações**. Você pode usar, copiar e distribuir o código-fonte e a documentação associados a este software exclusivamente para **fins de estudo**, desde que faça isso de forma não comercial. Para mais informações, consulte o arquivo LICENSE.

## 👤 Sobre o Autor

🔧 **Desenvolvedor:** Silas Sefas de Souza Aquino  
🌐 **LinkedIn:** [silassefas](https://www.linkedin.com/in/silassefas/)  
:octocat: **GitHub:** [silassefas1](https://github.com/silassefas1)

Sinta-se à vontade para me conectar nas redes sociais! Estou sempre aberto a novas oportunidades e colaborações. 🚀


Sinta-se à vontade para contribuir e melhorar o projeto! Quaisquer sugestões ou colaborações são bem-vindas. 😊  
