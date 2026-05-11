package padroescomportamentais.templatemethod;

public abstract class Relatorio {

    public final String gerar() {
        return cabecalho() + "\n" + corpo() + "\n" + rodape();
    }

    protected String cabecalho() {
        return "=== " + titulo() + " ===";
    }

    protected String rodape() {
        return "--- fim do relatório ---";
    }

    protected abstract String titulo();
    protected abstract String corpo();
}
