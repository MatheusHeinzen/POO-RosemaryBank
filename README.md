---

# Sistema Bancário Simples em Java

## Descrição

Este projeto é um sistema bancário simples desenvolvido em Java, como parte da disciplina de **Programação Orientada a Objetos (POO)**. O objetivo é permitir que o usuário possa:
- Cadastrar-se no sistema bancário;
- Realizar operações básicas como verificar saldo, sacar e depositar dinheiro;
- Editar os dados do usuário;

O sistema foi construído com princípios de POO, utilizando classes e métodos para organizar a lógica, encapsulando dados e responsabilidades.

## Estrutura do Projeto

O projeto é composto por três classes principais:

### 1. **Main**
Responsável por iniciar a aplicação e gerenciar o fluxo do sistema. Ela utiliza a classe `Scanner` para interagir com o usuário e oferece um menu para escolha de operações. 

### 2. **User (Usuário)**
Representa um cliente do banco. A classe contém os seguintes atributos:
- `nome`: Nome do cliente;
- `senha`: Senha de acesso;
- `anoNascimento`: Ano de nascimento do cliente;
- `cpf`: CPF do cliente;
- `renda`: Renda mensal do cliente;
- `email`: E-mail para contato.

Além disso, cada usuário possui uma **conta bancária** associada através da classe `BankAccount`.

### 3. **BankAccount (Conta Bancária)**
Representa uma conta bancária, contendo atributos relacionados ao saldo, crédito e fluxo de caixa. As principais operações da classe são:
- `sacar()`: Permite ao usuário sacar dinheiro de sua conta, caso tenha saldo suficiente;
- `depositar()`: Permite ao usuário depositar dinheiro em sua conta;
- `fazerEmprestimo()`: Permite ao usuário realizar um empréstimo até o limite do seu crédito.

## Funcionalidades

### Menu Inicial
- **Login**: Permite ao usuário acessar sua conta bancária usando login e senha.
- **Cadastro**: Permite que novos usuários criem uma conta no sistema, fornecendo nome, senha, e outras informações necessárias.

### Menu do Usuário
Após o login, o usuário tem acesso a várias funcionalidades, como:
1. **Verificar saldo**: Mostra o saldo atual da conta bancária.
2. **Sacar**: Permite que o usuário retire dinheiro de sua conta.
3. **Depositar**: Adiciona dinheiro à conta do usuário.
4. **Editar dados**: Permite que o usuário altere informações pessoais como senha e e-mail.

### Cadastro de Usuários
Os usuários cadastrados são armazenados em uma **lista** para fácil manipulação e consulta. Essa lista permite que o sistema suporte múltiplos clientes.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada no projeto.
- **POO (Programação Orientada a Objetos)**: O código segue os princípios da POO, como encapsulamento, responsabilidade única, e uso de métodos e classes para dividir a lógica.
- **Scanner**: Para entrada de dados do usuário.

## Como Executar o Código

1. **Clone o repositório** ou copie os arquivos `Main.java`, `User.java`, e `BankAccount.java` para seu ambiente local.
2. **Compile e execute** o arquivo `Main.java` em uma IDE de sua escolha ou usando o terminal/console com os seguintes comandos:

```bash
javac Main.java User.java BankAccount.java
java Main
```

3. Siga as instruções no console para cadastrar usuários, fazer login e realizar operações bancárias.

## Possíveis Melhorias

- Implementar tratamento de exceções para capturar entradas inválidas, como quando o usuário tenta sacar mais do que tem em conta ou digita dados incorretos.
- Adicionar persistência de dados para que as informações de usuários e suas contas sejam salvas entre execuções do programa.
- Implementar mais funcionalidades, como transferência entre contas e cálculo de juros sobre o saldo.

## Contribuição

Este projeto foi desenvolvido como parte de uma atividade acadêmica de POO. Sugestões e melhorias são sempre bem-vindas!

---
