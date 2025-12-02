## 💳 Projeto Pagamento – Sistema de Gerenciamento Bancário

Este repositório contém um sistema desenvolvido como projeto da disciplina de Programação Orientada a Objetos, pertencente ao curso de Desenvolvimento de Sistemas.

Criado por Bruno Sartori e Patrick Fedrigo, o sistema implementa uma arquitetura limpa (Clean Architecture), garantindo organização, escalabilidade e separação clara de responsabilidades.

🏛️ **Arquitetura do Projeto**

```
src/main/java
└── com
    └── cesurg
        └── projetopagamento
            ├── ProjetopagamentoApplication.java
            ├── core
            │   ├── domain
            │   │   ├── model
            │   │   │   ├── Banco.java
            │   │   │   ├── Conta.java
            │   │   │   ├── ContaCorrente.java
            │   │   │   ├── ContaCredito.java
            │   │   │   ├── ContaPoupanca.java
            │   │   │   └── Usuario.java
            │   │   └── usecase
            │   │       ├── BancoUseCaseImpl.java
            │   │       ├── ContaUseCaseImpl.java
            │   │       └── UsuarioUseCaseImpl.java
            │   └── interfaces
            │       ├── BancoRepository.java
            │       ├── BancoUseCase.java
            │       ├── ContaRepository.java
            │       ├── ContaUseCase.java
            │       ├── UsuarioRepository.java
            │       └── UsuarioUseCase.java
            └── infra
                ├── DTO
                │   ├── ContaCorrenteDTO.java
                │   ├── ContaCreditoDTO.java
                │   ├── ContaPoupancaDTO.java
                │   ├── OperacaoDTO.java
                │   └── TransferenciaDTO.java
                ├── controller
                │   ├── BancoController.java
                │   ├── ContaController.java
                │   └── UsuarioController.java
                ├── exception
                │   └── GlobalExceptionHandler.java
                └── repository
                    ├── BancoRepositoryImpl.java
                    ├── ContaRepositoryImpl.java
                    └── UsuarioRepositoryImpl.java
```

## 🔌 **Documentação Oficial da API**

A API é dividida em três módulos principais:

- Banco  
- Usuário  
- Conta bancária (corrente, poupança e crédito)

---

## 🏦 **1. Endpoints de Banco**

| Método | Rota              | Descrição                     |
|--------|-------------------|-------------------------------|
| POST   | /bancos           | Criar um banco                |
| PUT    | /bancos/{agencia} | Atualizar banco pela agência  |
| DELETE | /bancos/{agencia} | Remover banco pela agência    |
| GET    | /bancos           | Listar todos os bancos        |

✔️ **Exemplo de criação de banco (POST)**

```json
{
  "nome": "Banco do Brasil",
  "agencia": 1234
}
```

## 👤 **2. Endpoints de Usuário**

| Método | Rota           | Descrição             |
| ------ | -------------- | --------------------- |
| POST   | /usuarios      | Criar um usuário      |
| PUT    | /usuarios/{id} | Atualizar usuário     |
| DELETE | /usuarios/{id} | Remover usuário       |
| GET    | /usuarios      | Listar usuários       |
| GET    | /usuarios/{id} | Buscar usuário por ID |

✔️ **Exemplo (POST)**

```json
{
  "nome": "Bruno",
  "sobrenome": "Sartori",
  "cpf": "10101010101"
}
```

## 💼 **3. Endpoints de Conta**

| Método | Rota             | Tipo de Conta  |
| ------ | ---------------- | -------------- |
| POST   | /contas/corrente | Conta Corrente |
| POST   | /contas/poupanca | Conta Poupança |
| POST   | /contas/credito  | Conta Crédito  |


✔️ Conta Corrente – Exemplo
```json
{
  "usuarioId": 1,
  "bancoId": 1,
  "saldo": 1000.00,
  "taxaManutencao": 12.50
}
```

✔️ Conta Poupança – Exemplo
```json
{
  "usuarioId": 1,
  "bancoId": 1,
  "saldo": 1500.00,
  "taxaRendimento": 0.02
}
```

✔️ Conta Crédito – Exemplo
```json
{
  "usuarioId": 1,
  "bancoId": 1,
  "limite": 5000.00
}
```

## 🔁 Operações Financeiras

| Método | Rota               | Descrição                       |
| ------ | ------------------ | ------------------------------- |
| PUT    | /contas/atualizar  | Atualizar saldo (genérico)      |
| POST   | /contas/depositar  | Depositar valor                 |
| POST   | /contas/sacar      | Sacar valor                     |
| POST   | /contas/compra     | Registrar compra (crédito)      |
| POST   | /contas/transferir | Transferir entre contas         |
| POST   | /contas/rendimento | Aplicar rendimento em poupanças |

✔️ Exemplo – Depositar
```json
{
  "identificador": "CC-1-1234",
  "valor": 500
}
```

✔️ Exemplo – Transferência
```json
{
  "idOrigem": "CC-1-1234",
  "idDestino": "CP-1-1234",
  "valor": 1000.00
}
```
## 📚 Consultas e Remoção de Contas
| Método | Rota                    | Descrição     |
| ------ | ----------------------- | ------------- |
| GET    | /contas                 | Listar contas |
| GET    | /contas/{identificador} | Buscar conta  |
| DELETE | /contas/{id}            | Deletar conta |

## 🛠️ Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

H2 / PostgreSQL / MySQL

Maven

Padrões: Clean Architecture / Ports & Adapters

## ▶️ Executando o Projeto
```
mvn spring-boot:run
```

A API rodará em:
```
http://localhost:3000
```
### 👨‍💻 Autores

Bruno Sartori

Patrick Fedrigo

Curso: Desenvolvimento de Sistemas
Disciplina: Programação Orientada a Objetos

## 📄 Licença

Projeto acadêmico – uso livre para estudo.


