public class FinanciamentoImovel extends Financiamento {
    private double entrada;
    private int parcelas;
    private double valorParcela;
    private double jurosAnual = 0.08;

    public FinanciamentoImovel(Cliente cliente, double valorBem) {
        super(cliente, valorBem);
    }

    @Override
    public void avaliarFinanciamento() {
        if (cliente.getIdade() < 21) {
            aprovado = false;
            motivoReprovacao = "Idade mínima para financiamento de imóvel é 21 anos.";
            return;
        }

        entrada = valorBem * 0.20;
        double valorFinanciado = valorBem - entrada;

        parcelas = 360; // até 30 anos
        double taxaMensal = Math.pow(1 + jurosAnual, 1.0/12) - 1;
        valorParcela = (valorFinanciado * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -parcelas));

        if (valorParcela > cliente.getRendaMensal() * 0.30) {
            aprovado = false;
            motivoReprovacao = "Parcela excede 30% da renda mensal.";
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
