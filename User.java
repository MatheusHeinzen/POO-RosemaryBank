public class User {
    private String nome;
    private String senha;
    private int anoNascimento;
    private String cpf;
    private double renda;
    private String email;
    private BankAccount bankAccount;

    public User(String nome, int anoNascimento, String cpf, double renda, String email, String senha) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.cpf = cpf;
        this.renda = renda;
        this.email = email;
        this.senha = senha;
        this.bankAccount = new BankAccount();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
