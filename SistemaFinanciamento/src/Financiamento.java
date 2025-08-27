public abstract class Financiamento {

    protected Cliente cliente;
    protected double valorBem;
    protected boolean aprovado;
    protected String motivoReprovacao;

    public Financiamento(Cliente cliente, double valorBem) {
        this.cliente = cliente;
        this.valorBem = valorBem;
        this.aprovado = false;
    }

    public abstract void avaliarFinanciamento();

    public abstract void exibirResultado();

    public boolean isAprovado() {
        return aprovado;
    }

    public String getMotivoReprovacao() {
        return motivoReprovacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorBem() {
        return valorBem;
    }
}
