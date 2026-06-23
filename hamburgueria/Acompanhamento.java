package hamburgueria;

public class Acompanhamento implements ItemCardapio {

    private final String nome;
    private final double preco;

    public Acompanhamento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String descricao() {
        return this.nome;
    }

    @Override
    public double preco() {
        return this.preco;
    }
}
