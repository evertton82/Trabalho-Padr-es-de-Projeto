package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class AvisoCliente implements ObservadorPedido {

    private final List<String> mensagens = new ArrayList<>();

    @Override
    public void notificar(Pedido pedido, String evento) {
        if (Pedido.EVENTO_PRONTO.equals(evento)) {
            this.mensagens.add(pedido.getCliente().getNome() + ", seu pedido está pronto!");
        }
    }

    public List<String> getMensagens() {
        return this.mensagens;
    }
}
