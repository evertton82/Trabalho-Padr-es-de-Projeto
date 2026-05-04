package padroescomportamentais.state;

public class PedidoNovo implements EstadoPedido {

    public void pagar(Pedido pedido) {
        pedido.setEstado(new PedidoPago());
    }

    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido novo não pode ser enviado antes do pagamento");
    }

    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido novo não pode ser entregue");
    }

    public String nome() {
        return "NOVO";
    }
}
