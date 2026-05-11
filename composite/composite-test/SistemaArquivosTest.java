package padroesestruturais.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaArquivosTest {

    @Test
    void arquivoIsoladoDeveRetornarSeuTamanho() {
        ComponenteArquivo arquivo = new Arquivo("relatorio.pdf", 500);
        assertEquals(500, arquivo.tamanho());
        assertEquals("relatorio.pdf", arquivo.getNome());
    }

    @Test
    void pastaVaziaDeveTerTamanhoZero() {
        Pasta pasta = new Pasta("Documentos");
        assertEquals(0, pasta.tamanho());
    }

    @Test
    void pastaDeveSomarTamanhoDosArquivosFilhos() {
        Pasta pasta = new Pasta("Documentos");
        pasta.adicionar(new Arquivo("a.txt", 100));
        pasta.adicionar(new Arquivo("b.txt", 200));
        pasta.adicionar(new Arquivo("c.txt", 300));

        assertEquals(600, pasta.tamanho());
    }

    @Test
    void deveCalcularTamanhoRecursivoDePastasAninhadas() {
        Pasta raiz = new Pasta("Raiz");
        Pasta subPasta = new Pasta("Subpasta");
        subPasta.adicionar(new Arquivo("interno.txt", 150));
        subPasta.adicionar(new Arquivo("interno2.txt", 250));

        raiz.adicionar(new Arquivo("topo.txt", 100));
        raiz.adicionar(subPasta);

        assertEquals(500, raiz.tamanho());
    }

    @Test
    void deveRemoverComponenteDaPasta() {
        Pasta pasta = new Pasta("Documentos");
        ComponenteArquivo arquivo = new Arquivo("descartavel.txt", 999);
        pasta.adicionar(new Arquivo("permanente.txt", 100));
        pasta.adicionar(arquivo);
        assertEquals(1099, pasta.tamanho());

        pasta.remover(arquivo);
        assertEquals(100, pasta.tamanho());
    }
}
