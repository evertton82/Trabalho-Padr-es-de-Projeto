package padroescomportamentais.state;

public class PedidoPago implements EstadoPedido {

    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pago");
    }

    public void enviar(Pedido pedido) {
        pedido.setEstado(new PedidoEnviado());
    }

    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido pago precisa ser enviado antes de entregar");
    }

    public String nome() {
        return "PAGO";
    }
}
