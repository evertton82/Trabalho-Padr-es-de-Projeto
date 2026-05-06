package padroescomportamentais.chainofresponsibility;

public class Diretor extends Aprovador {

    private static final double LIMITE = 10000.00;

    public String aprovar(SolicitacaoDespesa solicitacao) {
        if (solicitacao.getValor() <= LIMITE) {
            return "Aprovado pelo Diretor: " + solicitacao.getDescricao();
        }
        if (this.proximo != null) {
            return this.proximo.aprovar(solicitacao);
        }
        return "Solicitação rejeitada: nenhum aprovador disponível";
    }
}
