import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1-Cadastrar gerente");
            System.out.println("2-Cadastrar cliente");
            System.out.println("3-Depositar");
            System.out.println("4-Sacar");
            System.out.println("5-Consultar saldo");
            System.out.println("6-Listar clientes por gerente");
            System.out.println("0-Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            if (opcao == 1) {
                System.out.print("Nome do gerente: ");
                gerentes.add(new Gerente(sc.nextLine()));

            } else if (opcao == 2) {
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Nome do gerente: ");
                String nomeGerente = sc.nextLine();

                Gerente gerente = null;
                for (Gerente g : gerentes) {
                    if (g.getNome().equalsIgnoreCase(nomeGerente)) gerente = g;
                }

                if (gerente == null) {
                    System.out.println("Gerente não encontrado.");
                } else {
                    Cliente c = new Cliente(nome, cpf, clientes.size() + 1);
                    clientes.add(c);
                    gerente.adicionarCliente(c);
                    System.out.println("Cliente cadastrado! Conta nº " + c.getConta().getNumero());
                }

            } else if (opcao >= 3 && opcao <= 5) {
                System.out.print("CPF do cliente: ");
                String cpf = sc.nextLine();

                Cliente cliente = null;
                for (Cliente c : clientes) {
                    if (c.getCpf().equals(cpf)) cliente = c;
                }

                if (cliente == null) {
                    System.out.println("Cliente não encontrado.");
                } else {
                    if (opcao == 3) {
                        System.out.print("Valor: ");
                        cliente.getConta().depositar(Double.parseDouble(sc.nextLine()));
                    } else if (opcao == 4) {
                        System.out.print("Valor: ");
                        cliente.getConta().sacar(Double.parseDouble(sc.nextLine()));
                    }
                    System.out.println("Saldo: R$ " + cliente.getConta().getSaldo());
                }

            } else if (opcao == 6) {
                System.out.print("Nome do gerente: ");
                String nomeGerente = sc.nextLine();

                Gerente gerente = null;
                for (Gerente g : gerentes) {
                    if (g.getNome().equalsIgnoreCase(nomeGerente)) gerente = g;
                }

                if (gerente == null) {
                    System.out.println("Gerente não encontrado.");
                } else {
                    gerente.listarClientes();
                }
            }
        } while (opcao != 0);
    }
}