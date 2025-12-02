💳 Projeto Pagamento – Sistema de Gerenciamento Bancário

Este repositório contém um sistema desenvolvido como projeto da disciplina de Programação Orientada a Objetos, pertencente ao curso de Desenvolvimento de Sistemas.
Criado por Bruno Sartori e Patrick Fedrigo, o sistema implementa uma arquitetura limpa (Clean Architecture), garantindo organização, escalabilidade e separação clara de responsabilidades.

🏛️ Arquitetura do Projeto
src/main/java/com.cesurg.projetopagamento
│
├── core
│   ├── domain
│   │   ├── model        # Entidades de domínio (Banco, Conta, Usuario...)
│   │   └── usecase      # Regras de negócio
│   ├── interfaces       # Portas de entrada e saída (contratos)
│
├── infra
│   ├── controller       # API REST
│   ├── DTO              # Objetos de transferência de dados
│   ├── exception        # Tratamento de erros
│   └── repository       # Persistência
│
└── ProjetopagamentoApplication

🔌 Documentação Oficial da API

A API é dividida em três módulos principais:

Banco

Usuário

Conta bancária (corrente, poupança e crédito)

Todos os endpoints estão documentados abaixo com seus respectivos caminhos e funções.

🏦 1. Endpoints de Banco
Método	Rota	Descrição
POST	/bancos	Criar um banco
PUT	/bancos/{agencia}	Atualizar banco pela agência
DELETE	/bancos/{agencia}	Remover banco pela agência
GET	/bancos	Listar todos os bancos

✔️ Exemplo de criação de banco (POST)
{
  "nome": "Banco do Brasil",
  "agencia": 1234
}

👤 2. Endpoints de Usuário
Método	Rota	Descrição
POST	/usuarios	Criar um usuário
PUT	/usuarios/{id}	Atualizar usuário
DELETE	/usuarios/{id}	Remover usuário
GET	/usuarios	Listar usuários
GET	/usuarios/{id}	Buscar usuário por ID

✔️ Exemplo de criação de usuário (POST)
{
  "nome": "Bruno",
  "cpf": "12345678900"
}

💼 3. Endpoints de Conta

Módulo responsável por contas corrente, poupança e crédito.

🏦 Criar contas
Método	Rota	Tipo de Conta	Corpo da Requisição
POST	/contas/corrente	Conta Corrente	ContaCorrenteDTO
POST	/contas/poupanca	Conta Poupança	ContaPoupancaDTO
POST	/contas/credito	Conta Crédito	ContaCreditoDTO

✔️ Conta Corrente – Exemplo
{
  "usuarioId": 1,
  "bancoId": 1,
  "saldo": 1000.00,
  "taxaManutencao": 12.50
}

✔️ Conta Poupança – Exemplo
{
  "usuarioId": 1,
  "bancoId": 1,
  "saldo": 1500.00,
  "taxaRendimento": 0.02
}

✔️ Conta Crédito – Exemplo
{
  "usuarioId": 1,
  "bancoId": 1,
  "limite": 5000.00
}

🔁 Operações financeiras
Método	Rota	Descrição
PUT	/contas/atualizar	Atualizar saldo (genérico)
POST	/contas/depositar	Depositar valor
POST	/contas/sacar	Sacar valor
POST	/contas/compra	Registrar compra (conta crédito)
POST	/contas/transferir	Transferir entre contas
POST	/contas/rendimento	Aplicar rendimentos nas poupanças

✔️ Exemplo – Depositar
{
  "identificador": "CC-1-1234",
  "valor": 500
}

✔️ Exemplo – Transferência
{
  "idOrigem": "CC-1-1234",
  "idDestino": "CP-1-1234",
  "valor": 1000.00
}

📚 Consultas e remoção de contas
Método	Rota	Descrição
GET	/contas	Listar todas as contas
GET	/contas/{identificador}	Buscar conta por identificador
DELETE	/contas/{id}	Deletar conta

🛠️ Tecnologias Utilizadas

Java 17+
Spring Boot
Spring Web
Spring Data JPA
H2 / PostgreSQL / MySQL
Maven

Padrões de arquitetura: Clean Architecture / Ports & Adapters

▶️ Executando o Projeto
mvn spring-boot:run

API rodará em:
http://localhost:3000

👨‍💻 Autores

Bruno Sartori
Patrick Fedrigo

Curso: Desenvolvimento de Sistemas
Disciplina: Programação Orientada a Objetos

📄 Licença
Projeto acadêmico – uso livre para estudo.
