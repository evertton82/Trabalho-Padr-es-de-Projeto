package hamburgueria;

public interface ObservadorPedido {
    void notificar(Pedido pedido, String evento);
}
