public class Cliente {

    private String nome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(String nome, String cpf, int numeroConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = new ContaBancaria(numeroConta); // uma única conta
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public ContaBancaria getConta() { return conta; }
}