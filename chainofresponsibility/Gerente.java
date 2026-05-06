package padroescomportamentais.chainofresponsibility;

public class Gerente extends Aprovador {

    private static final double LIMITE = 1000.00;

    public String aprovar(SolicitacaoDespesa solicitacao) {
        if (solicitacao.getValor() <= LIMITE) {
            return "Aprovado pelo Gerente: " + solicitacao.getDescricao();
        }
        if (this.proximo != null) {
            return this.proximo.aprovar(solicitacao);
        }
        return "Solicitação rejeitada: nenhum aprovador disponível";
    }
}
