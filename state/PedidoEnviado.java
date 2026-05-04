package padroescomportamentais.state;

public class PedidoEnviado implements EstadoPedido {

    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pago");
    }

    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está enviado");
    }

    public void entregar(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    public String nome() {
        return "ENVIADO";
    }
}
