package padroescomportamentais.templatemethod;

public class RelatorioVendas extends Relatorio {

    protected String titulo() {
        return "Relatório de Vendas";
    }

    protected String corpo() {
        return "Total vendido no período: R$ 10.000,00";
    }
}
