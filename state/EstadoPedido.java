package padroescomportamentais.state;

public interface EstadoPedido {
    void pagar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    String nome();
}
