package padroescomportamentais.chainofresponsibility;

public class CEO extends Aprovador {

    private static final double LIMITE = 100000.00;

    public String aprovar(SolicitacaoDespesa solicitacao) {
        if (solicitacao.getValor() <= LIMITE) {
            return "Aprovado pelo CEO: " + solicitacao.getDescricao();
        }
        if (this.proximo != null) {
            return this.proximo.aprovar(solicitacao);
        }
        return "Solicitação rejeitada: valor excede o limite máximo de aprovação";
    }
}
