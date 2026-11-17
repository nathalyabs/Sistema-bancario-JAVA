import java.util.ArrayList;

public class Gerente {

    private String nome;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Gerente(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            System.out.println("- " + c.getNome() + " | CPF: " + c.getCpf());
        }
    }
}