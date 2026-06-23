package hamburgueria;

public interface SituacaoPedido {
    void iniciarPreparo(Pedido pedido);
    void marcarPronto(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
    String nome();
}
