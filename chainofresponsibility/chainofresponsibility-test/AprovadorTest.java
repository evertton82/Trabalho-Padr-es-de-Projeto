package padroescomportamentais.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AprovadorTest {

    private Aprovador cadeia;

    @BeforeEach
    void montarCadeia() {
        Aprovador gerente = new Gerente();
        Aprovador diretor = new Diretor();
        Aprovador ceo = new CEO();
        gerente.setProximo(diretor).setProximo(ceo);
        this.cadeia = gerente;
    }

    @Test
    void gerenteDeveAprovarValoresAteMilReais() {
        SolicitacaoDespesa solicitacao = new SolicitacaoDespesa("Material de escritório", 800.00);
        assertEquals("Aprovado pelo Gerente: Material de escritório", cadeia.aprovar(solicitacao));
    }

    @Test
    void diretorDeveAprovarValoresAcimaDoGerenteAteDezMil() {
        SolicitacaoDespesa solicitacao = new SolicitacaoDespesa("Notebook", 5000.00);
        assertEquals("Aprovado pelo Diretor: Notebook", cadeia.aprovar(solicitacao));
    }

    @Test
    void ceoDeveAprovarValoresAcimaDoDiretorAteCemMil() {
        SolicitacaoDespesa solicitacao = new SolicitacaoDespesa("Servidor", 50000.00);
        assertEquals("Aprovado pelo CEO: Servidor", cadeia.aprovar(solicitacao));
    }

    @Test
    void deveRejeitarValoresAcimaDoLimiteMaximo() {
        SolicitacaoDespesa solicitacao = new SolicitacaoDespesa("Aquisição de empresa", 500000.00);
        assertEquals("Solicitação rejeitada: valor excede o limite máximo de aprovação", cadeia.aprovar(solicitacao));
    }

    @Test
    void deveAprovarValorExatamenteNoLimiteDoGerente() {
        SolicitacaoDespesa solicitacao = new SolicitacaoDespesa("Cadeira ergonômica", 1000.00);
        assertEquals("Aprovado pelo Gerente: Cadeira ergonômica", cadeia.aprovar(solicitacao));
    }
}
