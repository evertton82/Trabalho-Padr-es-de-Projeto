package padroescomportamentais.chainofresponsibility;

public abstract class Aprovador {

    protected Aprovador proximo;

    public Aprovador setProximo(Aprovador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract String aprovar(SolicitacaoDespesa solicitacao);
}
