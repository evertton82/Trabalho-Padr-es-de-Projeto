package padroescomportamentais.templatemethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioTest {

    @Test
    void deveGerarRelatorioDeVendasCompleto() {
        Relatorio relatorio = new RelatorioVendas();
        String esperado = "=== Relatório de Vendas ===\n"
                + "Total vendido no período: R$ 10.000,00\n"
                + "--- fim do relatório ---";
        assertEquals(esperado, relatorio.gerar());
    }

    @Test
    void deveGerarRelatorioDeEstoqueCompleto() {
        Relatorio relatorio = new RelatorioEstoque();
        String esperado = "=== Relatório de Estoque ===\n"
                + "Itens em estoque: 250 unidades\n"
                + "--- fim do relatório ---";
        assertEquals(esperado, relatorio.gerar());
    }

    @Test
    void cabecalhoDevePossuirOTituloDaSubclasse() {
        Relatorio relatorio = new RelatorioVendas();
        assertTrue(relatorio.gerar().startsWith("=== Relatório de Vendas ==="));
    }

    @Test
    void rodapeDeveSerOMesmoEmTodosOsRelatorios() {
        Relatorio vendas = new RelatorioVendas();
        Relatorio estoque = new RelatorioEstoque();
        assertTrue(vendas.gerar().endsWith("--- fim do relatório ---"));
        assertTrue(estoque.gerar().endsWith("--- fim do relatório ---"));
    }
}
