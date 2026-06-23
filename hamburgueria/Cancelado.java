package hamburgueria;

public class Cancelado implements SituacaoPedido {

    @Override
    public void iniciarPreparo(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode ser alterado");
    }

    @Override
    public void marcarPronto(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode ser alterado");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado não pode ser entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já está cancelado");
    }

    @Override
    public String nome() {
        return "CANCELADO";
    }
}
