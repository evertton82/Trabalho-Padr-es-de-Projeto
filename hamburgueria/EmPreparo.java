package hamburgueria;

public class EmPreparo implements SituacaoPedido {

    @Override
    public void iniciarPreparo(Pedido pedido) {
        throw new IllegalStateException("Pedido já está em preparo");
    }

    @Override
    public void marcarPronto(Pedido pedido) {
        pedido.mudarSituacao(new Pronto(), Pedido.EVENTO_PRONTO);
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido em preparo precisa ficar pronto antes de ser entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido em preparo não pode ser cancelado");
    }

    @Override
    public String nome() {
        return "EM_PREPARO";
    }
}
