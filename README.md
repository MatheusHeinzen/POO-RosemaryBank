---

# Sistema Bancário Simples

## Sobre o projeto

Esse projeto é um sistema bancário básico feito em Java para uma atividade de **Programação Orientada a Objetos (POO)**. Com ele, dá para:

- Cadastrar um novo usuário.
- Fazer login.
- Ver saldo, sacar e depositar dinheiro.
- Alterar os dados do usuário.

## Estrutura do projeto

O código tem três partes principais:

### 1. **Main**
É onde o sistema começa. Ele mostra o menu, pede o login ou cadastro, e direciona o usuário para as operações.

### 2. **User (Usuário)**
Guarda as informações do cliente, como nome, senha, CPF, e-mail, renda, e ano de nascimento. Cada usuário tem uma **conta bancária** ligada a ele.

### 3. **BankAccount (Conta Bancária)**
Aqui ficam as operações da conta, como ver saldo, sacar dinheiro e depositar.

## Funcionalidades

### Menu Principal
- **Login**: Para acessar a conta com o nome de usuário e senha.
- **Cadastro**: Para criar uma nova conta no banco.

### Menu do Usuário
Depois de logar, o usuário pode:
1. **Ver saldo**.
2. **Sacar dinheiro**.
3. **Depositar dinheiro**.
4. **Alterar dados pessoais** (como senha e e-mail).

### Lista de usuários
Os usuários cadastrados ficam guardados numa lista.

## Como rodar o código

1. Baixe ou copie os arquivos `Main.java`, `User.java`, e `BankAccount.java`.
2. Rode o arquivo `Main.java` usando qualquer IDE ou terminal:

```bash
javac Main.java User.java BankAccount.java
java Main
```

3. Siga o que aparece na tela para cadastrar e usar o sistema bancário.

## Melhorias futuras

- Adicionar uma forma de salvar os dados para não perder as contas quando o programa fecha.
- Colocar mais funções, como transferências entre contas.

---
