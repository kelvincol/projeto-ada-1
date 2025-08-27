public class Cliente {

    private String nome;
    private int idade;
    private double rendaMensal;

    public Cliente(String nome, int idade, double rendaMensal) {
        this.nome = nome;
        this.idade = idade;
        this.rendaMensal = rendaMensal;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }
}



