package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class PainelCozinha implements ObservadorPedido {

    private final List<String> mensagens = new ArrayList<>();

    @Override
    public void notificar(Pedido pedido, String evento) {
        if (Pedido.EVENTO_EM_PREPARO.equals(evento)) {
            this.mensagens.add("Cozinha: preparar " + pedido.descricaoItem());
        }
    }

    public List<String> getMensagens() {
        return this.mensagens;
    }
}
