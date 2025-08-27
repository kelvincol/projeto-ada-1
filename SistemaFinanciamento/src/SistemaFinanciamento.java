import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaFinanciamento {
    private static List<FinanciamentoImovel> financiamentosImoveis = new ArrayList<>();
    private static List<FinanciamentoVeiculo> financiamentosVeiculos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Financiamento de Imóvel");
            System.out.println("2 - Financiamento de Veículo");
            System.out.println("3 - Listar Financiamentos de Imóveis");
            System.out.println("4 - Listar Financiamentos de Veículos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarFinanciamentoImovel(sc);
                    break;
                case 2:
                    cadastrarFinanciamentoVeiculo(sc);
                    break;
                case 3:
                    listarFinanciamentosImoveis();
                    break;
                case 4:
                    listarFinanciamentosVeiculos();
                    break;
                case 0:
                    System.out.println("Obrigado por usar nossos serviços!");
                    break;
                default:
                    if (opcao != -1) {
                        System.out.println("Opção inválida!");
                    }
            }
        } while (opcao != 0);

        sc.close();
    }

    private static Cliente solicitarDadosCliente(Scanner sc) {
        String nome = "";
        int idade = 0;
        double renda = 0.0;

        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Digite seu nome: ");
                nome = ValidadorEntrada.lerNome(sc);
                valido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        valido = false;
        while (!valido) {
            try {
                System.out.print("Digite sua idade: ");
                idade = ValidadorEntrada.lerInteiro(sc);
                valido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        valido = false;
        while (!valido) {
            try {
                System.out.print("Digite sua renda mensal: ");
                renda = ValidadorEntrada.lerDouble(sc);
                valido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Cliente(nome, idade, renda);
    }

    private static void cadastrarFinanciamentoImovel(Scanner sc) {
        Cliente cliente = solicitarDadosCliente(sc);
        double valor = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = ValidadorEntrada.lerDouble(sc);
                valido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        FinanciamentoImovel financiamento = new FinanciamentoImovel(cliente, valor);
        financiamento.avaliarFinanciamento();
        financiamento.exibirResultado();
        financiamentosImoveis.add(financiamento);
    }

    private static void cadastrarFinanciamentoVeiculo(Scanner sc) {
        Cliente cliente = solicitarDadosCliente(sc);
        double valor = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Digite o valor do veículo: ");
                valor = ValidadorEntrada.lerDouble(sc);
                valido = true;
            } catch (DadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        FinanciamentoVeiculo financiamento = new FinanciamentoVeiculo(cliente, valor);
        financiamento.avaliarFinanciamento();
        financiamento.exibirResultado();
        financiamentosVeiculos.add(financiamento);
    }

    private static void listarFinanciamentosImoveis() {
        System.out.println("\n--- LISTA DE FINANCIAMENTOS DE IMÓVEIS ---");
        for (FinanciamentoImovel f : financiamentosImoveis) {
            System.out.printf("Cliente: %s | Valor: R$ %.2f | Status: %s%n",
                    f.getCliente().getNome(), f.getValorBem(), f.isAprovado() ? "Aprovado" : "Reprovado");
            if (!f.isAprovado()) {
                System.out.println("Motivo: " + f.getMotivoReprovacao());
            }
        }
    }

    private static void listarFinanciamentosVeiculos() {
        System.out.println("\n--- LISTA DE FINANCIAMENTOS DE VEÍCULOS ---");
        for (FinanciamentoVeiculo f : financiamentosVeiculos) {
            System.out.printf("Cliente: %s | Valor: R$ %.2f | Status: %s%n",
                    f.getCliente().getNome(), f.getValorBem(), f.isAprovado() ? "Aprovado" : "Reprovado");
            if (!f.isAprovado()) {
                System.out.println("Motivo: " + f.getMotivoReprovacao());
            }
        }
    }
}