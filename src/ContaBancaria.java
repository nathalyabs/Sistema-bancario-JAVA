public class ContaBancaria {

    private int numero;
    private double saldo;

    public ContaBancaria(int numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) saldo -= valor;
    }
}