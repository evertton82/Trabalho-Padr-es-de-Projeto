package padroescomportamentais.templatemethod;

public class RelatorioEstoque extends Relatorio {

    protected String titulo() {
        return "Relatório de Estoque";
    }

    protected String corpo() {
        return "Itens em estoque: 250 unidades";
    }
}
