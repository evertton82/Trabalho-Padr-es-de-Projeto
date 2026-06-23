package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class RegistroGerencial implements ObservadorPedido {

    private final List<String> mensagens = new ArrayList<>();

    @Override
    public void notificar(Pedido pedido, String evento) {
        if (Pedido.EVENTO_ENTREGUE.equals(evento)) {
            this.mensagens.add("Gerência: pedido de " + pedido.getCliente().getNome() + " entregue");
        }
        if (Pedido.EVENTO_CANCELADO.equals(evento)) {
            this.mensagens.add("Gerência: pedido de " + pedido.getCliente().getNome() + " cancelado");
        }
    }

    public List<String> getMensagens() {
        return this.mensagens;
    }
}
