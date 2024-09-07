public class BankAccount {
    private double saldo;
    private double credito;
    private double divida;

    public BankAccount() {
        this.saldo = 0.0;
        this.credito = 5000.0;
        this.divida = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getCredito() {
        return credito;
    }

    public double getDivida() {
        return divida;
    }

    public double sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return saldo;
        } else {
            return -1;
        }
    }

    public double depositar(double valor) {
        saldo += valor;
        return saldo;
    }

    public double fazerEmprestimo(double valor) {
        if (valor <= credito) {
            saldo += valor;
            divida += valor;
            credito -= valor;
            return saldo;
        } else {
            return -1;
        }
    }

    public double pagarDivida(double valor) {
        if (divida > 0 && valor <= divida && saldo >= valor) {
            divida -= valor;
            saldo -= valor;
            credito += valor;
            return divida;
        } else {
            return -1;
        }
    }
}
