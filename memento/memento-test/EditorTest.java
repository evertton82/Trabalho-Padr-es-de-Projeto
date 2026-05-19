package padroescomportamentais.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {

    @Test
    void deveSalvarERestaurarConteudo() {
        Editor editor = new Editor();
        editor.digitar("Ola");
        EditorMemento snapshot = editor.salvar();

        editor.digitar(" mundo");
        assertEquals("Ola mundo", editor.getConteudo());

        editor.restaurar(snapshot);
        assertEquals("Ola", editor.getConteudo());
    }

    @Test
    void deveDesfazerVariasEdicoesUsandoHistorico() {
        Editor editor = new Editor();
        Historico historico = new Historico();

        historico.empilhar(editor.salvar());
        editor.digitar("A");

        historico.empilhar(editor.salvar());
        editor.digitar("B");

        historico.empilhar(editor.salvar());
        editor.digitar("C");

        assertEquals("ABC", editor.getConteudo());

        editor.restaurar(historico.desempilhar());
        assertEquals("AB", editor.getConteudo());

        editor.restaurar(historico.desempilhar());
        assertEquals("A", editor.getConteudo());

        editor.restaurar(historico.desempilhar());
        assertEquals("", editor.getConteudo());
    }

    @Test
    void deveRetornarNuloAoDesempilharHistoricoVazio() {
        Historico historico = new Historico();
        assertTrue(historico.vazio());
        assertNull(historico.desempilhar());
    }

    @Test
    void mementoDeveSerImutavelMesmoQuandoEditorMuda() {
        Editor editor = new Editor();
        editor.digitar("inicial");
        EditorMemento snapshot = editor.salvar();

        editor.limpar();
        editor.digitar("alterado");

        assertEquals("inicial", snapshot.getConteudo());
        assertEquals("alterado", editor.getConteudo());
    }
}
