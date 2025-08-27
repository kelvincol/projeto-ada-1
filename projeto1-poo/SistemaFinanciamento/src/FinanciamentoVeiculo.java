public class FinanciamentoVeiculo extends Financiamento {
    private double entrada;
    private int parcelas;
    private double valorParcela;
    private double jurosMensal = 0.015;

    public FinanciamentoVeiculo(Cliente cliente, double valorBem) {
        super(cliente, valorBem);
    }

    @Override
    public void avaliarFinanciamento() {
        if (cliente.getIdade() < 18) {
            aprovado = false;
            motivoReprovacao = "Idade mínima para financiamento de veículo é 18 anos.";
            return;
        }

        entrada = valorBem * 0.10;
        double valorFinanciado = valorBem - entrada;

        parcelas = 60; // até 5 anos
        valorParcela = (valorFinanciado * jurosMensal) / (1 - Math.pow(1 + jurosMensal, -parcelas));

        if (valorParcela > cliente.getRendaMensal() * 0.20) {
            aprovado = false;
            motivoReprovacao = "Parcela excede 20% da renda mensal.";
        } else {
            aprovado = true;
        }
    }

    @Override
    public void exibirResultado() {
        if (aprovado) {
            System.out.println("Financiamento Aprovado!");
            System.out.printf("Entrada mínima: R$ %.2f%n", entrada);
            System.out.printf("Valor financiado: R$ %.2f%n", valorBem - entrada);
            System.out.printf("Número de parcelas: %d%n", parcelas);
            System.out.printf("Valor da parcela: R$ %.2f%n", valorParcela);
        } else {
            System.out.println("Financiamento Reprovado!");
            System.out.println("Motivo: " + motivoReprovacao);
        }
    }
}
