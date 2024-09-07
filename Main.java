import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Lista para armazenar os usuários cadastrados
    static List<User> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem-vindo ao Banco Rosemary!");
            System.out.println("[1] - Login\n[2] - Cadastro\n[3] - Sair");
            String menu = sc.nextLine();

            switch (menu) {
                case "1": //Entrar na conta
                    System.out.println("Digite seu login: ");
                    String login = sc.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = sc.nextLine();

                    User usuarioExistente = buscarUsuario(login, senha);
                    if (usuarioExistente != null) {
                        System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioExistente.getNome());
                        exibirMenuBancario(usuarioExistente, sc);
                    } else {
                        System.out.println("Login ou senha inválidos.");
                    }
                    break;

                case "2": // Cadastro de novo usuário
                    System.out.println("Digite seu nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite uma senha: ");
                    String senhaCadastro = sc.nextLine();
                    System.out.println("Digite seu ano de nascimento: ");
                    int anoNascimento = Integer.parseInt(sc.nextLine());
                    System.out.println("Digite seu CPF: ");
                    String cpf = sc.nextLine();
                    System.out.println("Digite sua renda: ");
                    double renda = Double.parseDouble(sc.nextLine());
                    System.out.println("Digite seu email: ");
                    String email = sc.nextLine();

                    // Criando um novo usuário
                    User novoUsuario = new User(nome, anoNascimento, cpf, renda, email, senhaCadastro);
                    usuarios.add(novoUsuario); // Adicionando o novo usuário à lista

                    System.out.println("Cadastro realizado com sucesso.");
                    break;

                case "3": // Sair
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        sc.close();
    }

    // Função para buscar usuário na lista
    public static User buscarUsuario(String login, String senha) {
        for (User usuario : usuarios) {
            if (usuario.getNome().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    // Exibe o menu bancário após o login
    public static void exibirMenuBancario(User usuario, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menu Bancário ---");
            System.out.println("[1] - Ver saldo\n[2] - Sacar\n[3] - Depositar\n[4] - Fazer empréstimo\n[5] - Sair");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1": // Ver saldo
                    System.out.println("Seu saldo é: R$ " + usuario.getBankAccount().getSaldo());
                    break;

                case "2": // Sacar
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = Double.parseDouble(sc.nextLine());
                    double novoSaldoSaque = usuario.getBankAccount().sacar(valorSaque);
                    if (novoSaldoSaque == -1) {
                        System.out.println("Saldo insuficiente.");
                    } else {
                        System.out.println("Saque realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoSaque);
                    }
                    break;

                case "3": // Depositar
                    System.out.println("Digite o valor a ser depositado: ");
                    double valorDeposito = Double.parseDouble(sc.nextLine());
                    double novoSaldoDeposito = usuario.getBankAccount().depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoDeposito);
                    break;

                case "4": // Fazer empréstimo
                    double creditoAtual = usuario.getBankAccount().getCredito();
                    System.out.println("Você possui um crédito de R$" + creditoAtual + "Digite o valor do empréstimo: ");
                    double valorEmprestimo = Double.parseDouble(sc.nextLine());
                    double novoSaldoEmprestimo = usuario.getBankAccount().fazerEmprestimo(valorEmprestimo);
                    if (novoSaldoEmprestimo >= 0) {
                        System.out.println("Empréstimo realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoEmprestimo);
                        break;
                    } else {
                        System.out.println("Você não possui mais crédito para fazer empréstimo.");
                    }
                case "5": //Pagar dívida
                    double dividaAgora = usuario.getBankAccount().getDivida();
                    if (dividaAgora <= 0){
                        System.out.println("Você não possui dívidas a pagar.");
                    } else {
                        System.out.println("Sua dívida no momento é de R$ " + dividaAgora + "\nDeseje o quanto quer pagar da dívida:");
                        double valorPagamento = Double.parseDouble(sc.nextLine());
                        double novoSaldoCredito = usuario.getBankAccount().pagarDivida(valorPagamento);
                        if (novoSaldoCredito == -1) {
                            System.out.println("O valor depositado foi a cima do necessário ou o saldo não é suficiente para a transação, verifique suas informações.");
                        } else {
                            System.out.println("A sua dívida agora é de: R$ " + novoSaldoCredito);
                        }
                    }


                case "6": // Sair do menu bancário
                    System.out.println("Saindo do menu bancário.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
