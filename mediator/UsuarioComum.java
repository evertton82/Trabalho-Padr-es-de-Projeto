package padroescomportamentais.mediator;

import java.util.ArrayList;
import java.util.List;

public class UsuarioComum extends Usuario {

    private final List<String> caixaEntrada = new ArrayList<>();

    public UsuarioComum(String nome) {
        super(nome);
    }

    public void enviar(String mensagem) {
        this.mediador.enviar(mensagem, this);
    }

    public void receber(String mensagem, String remetente) {
        this.caixaEntrada.add(remetente + ": " + mensagem);
    }

    public List<String> getCaixaEntrada() {
        return this.caixaEntrada;
    }
}
