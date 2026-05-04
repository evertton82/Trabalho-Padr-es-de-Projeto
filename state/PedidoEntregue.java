package padroescomportamentais.state;

public class PedidoEntregue implements EstadoPedido {

    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já entregue não pode ser pago novamente");
    }

    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido já entregue não pode ser enviado novamente");
    }

    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está entregue");
    }

    public String nome() {
        return "ENTREGUE";
    }
}
