public class BankAccount {
    private double saldo = 0;
    private double credito = 5000; // Valor inicial de crédito
    private double fluxo = 0;
    private double divida = 0;

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
        if (saldo < valor) {
            return -1; // Indica saldo insuficiente
        } else {
            saldo -= valor;
            fluxo -= valor;
            return saldo;
        }
    }

    public double depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            fluxo += valor;
        }
        return saldo;
    }

    public double fazerEmprestimo(double valor) {
        if (valor <= credito) {
            credito -= valor;
            saldo += valor;
            divida += valor;
        } else {
            return -1;
        }
        return saldo;
    }
    public double pagarDivida(double valor) {
        if (valor <= divida && valor <= saldo) {
            credito += valor;
            saldo -= valor;
            divida -= valor;
        } else{
            return -1;
        }
        return divida;
    }
}

