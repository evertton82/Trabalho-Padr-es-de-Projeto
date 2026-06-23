package hamburgueria;

public class Entregue implements SituacaoPedido {

    @Override
    public void iniciarPreparo(Pedido pedido) {
        throw new IllegalStateException("Pedido entregue não pode ser alterado");
    }

    @Override
    public void marcarPronto(Pedido pedido) {
        throw new IllegalStateException("Pedido entregue não pode ser alterado");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido entregue não pode ser cancelado");
    }

    @Override
    public String nome() {
        return "ENTREGUE";
    }
}
