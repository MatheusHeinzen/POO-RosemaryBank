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
                case "1": // Entrar na conta
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
                    try {
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
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Insira valores numéricos corretamente.");
                    }
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
            System.out.println("[1] - Ver saldo\n[2] - Sacar\n[3] - Depositar\n[4] - Fazer empréstimo\n[5] - Pagar dívida\n[6] - Editar informações do usuário\n[7] - Sair");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1": // Ver saldo
                    System.out.println("Seu saldo é: R$ " + usuario.getBankAccount().getSaldo());
                    break;

                case "2": // Sacar
                    try {
                        System.out.println("Digite o valor a ser sacado: ");
                        double valorSaque = Double.parseDouble(sc.nextLine());
                        double novoSaldoSaque = usuario.getBankAccount().sacar(valorSaque);
                        if (novoSaldoSaque == -1) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            System.out.println("Saque realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoSaque);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Insira um valor numérico válido.");
                    }
                    break;

                case "3": // Depositar
                    try {
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = Double.parseDouble(sc.nextLine());
                        double novoSaldoDeposito = usuario.getBankAccount().depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoDeposito);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Insira um valor numérico válido.");
                    }
                    break;

                case "4": // Fazer empréstimo
                    try {
                        double creditoAtual = usuario.getBankAccount().getCredito();
                        System.out.println("Você possui um crédito de R$" + creditoAtual + ". Digite o valor do empréstimo: ");
                        double valorEmprestimo = Double.parseDouble(sc.nextLine());
                        double novoSaldoEmprestimo = usuario.getBankAccount().fazerEmprestimo(valorEmprestimo);
                        if (novoSaldoEmprestimo >= 0) {
                            System.out.println("Empréstimo realizado com sucesso. Seu novo saldo é: R$ " + novoSaldoEmprestimo);
                        } else {
                            System.out.println("Você não possui crédito suficiente para fazer o empréstimo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Insira um valor numérico válido.");
                    }
                    break;

                case "5": // Pagar dívida
                    try {
                        double dividaAgora = usuario.getBankAccount().getDivida();
                        if (dividaAgora <= 0) {
                            System.out.println("Você não possui dívidas a pagar.");
                        } else {
                            System.out.println("Sua dívida no momento é de R$ " + dividaAgora + ". Quanto deseja pagar da dívida?");
                            double valorPagamento = Double.parseDouble(sc.nextLine());
                            double novoSaldoCredito = usuario.getBankAccount().pagarDivida(valorPagamento);
                            if (novoSaldoCredito == -1) {
                                System.out.println("Erro: O valor inserido é maior que a dívida ou o saldo não é suficiente.");
                            } else {
                                System.out.println("Pagamento realizado. Sua dívida agora é de: R$ " + novoSaldoCredito);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Insira um valor numérico válido.");
                    }
                    break;

                case "6": // Editar informações do usuário
                    editarInformacoesUsuario(usuario, sc);
                    break;

                case "7": // Sair do menu bancário
                    System.out.println("Saindo do menu bancário.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    // Função para editar informações do usuário
    public static void editarInformacoesUsuario(User usuario, Scanner sc) {
        System.out.println("\n--- Editar Informações ---");
        System.out.println("[1] - Alterar senha\n[2] - Alterar email\n[3] - Alterar renda\n[4] - Voltar");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1": // Alterar senha
                System.out.println("Digite sua nova senha: ");
                String novaSenha = sc.nextLine();
                usuario.setSenha(novaSenha);
                System.out.println("Senha alterada com sucesso!");
                break;

            case "2": // Alterar email
                System.out.println("Digite seu novo email: ");
                String novoEmail = sc.nextLine();
                usuario.setEmail(novoEmail);
                System.out.println("Email alterado com sucesso!");
                break;

            case "3": // Alterar renda
                try {
                    System.out.println("Digite sua nova renda: ");
                    double novaRenda = Double.parseDouble(sc.nextLine());
                    usuario.setRenda(novaRenda);
                    System.out.println("Renda alterada com sucesso!");
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Insira um valor numérico válido.");
                }
                break;

            case "4": // Voltar
                System.out.println("Voltando ao menu...");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}
