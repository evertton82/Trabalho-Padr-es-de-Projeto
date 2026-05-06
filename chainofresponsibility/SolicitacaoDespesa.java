package padroescomportamentais.chainofresponsibility;

public class SolicitacaoDespesa {

    private final String descricao;
    private final double valor;

    public SolicitacaoDespesa(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValor() {
        return this.valor;
    }
}
