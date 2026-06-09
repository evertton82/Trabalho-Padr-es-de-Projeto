package padroescomportamentais.command;

public class ComandoPrato implements IComando {

    private final Cozinha cozinha;
    private final String prato;

    public ComandoPrato(Cozinha cozinha, String prato) {
        this.cozinha = cozinha;
        this.prato = prato;
    }

    @Override
    public String executar() {
        return cozinha.prepararPrato(prato);
    }

    @Override
    public String cancelar() {
        return cozinha.descartarPrato(prato);
    }
}
