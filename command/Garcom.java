package padroescomportamentais.command;

import java.util.ArrayList;
import java.util.List;

public class Garcom {

    private final List<IComando> comandas = new ArrayList<IComando>();

    public String anotarEEnviar(IComando comando) {
        this.comandas.add(comando);
        return comando.executar();
    }

    public String cancelarUltimoPedido() {
        if (comandas.size() != 0) {
            IComando comando = this.comandas.get(this.comandas.size() - 1);
            this.comandas.remove(this.comandas.size() - 1);
            return comando.cancelar();
        }
        return "Nenhum pedido para cancelar";
    }

    public int pedidosPendentes() {
        return comandas.size();
    }
}
