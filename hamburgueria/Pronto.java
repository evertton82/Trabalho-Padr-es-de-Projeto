package hamburgueria;

public class Pronto implements SituacaoPedido {

    @Override
    public void iniciarPreparo(Pedido pedido) {
        throw new IllegalStateException("Pedido pronto não pode voltar para preparo");
    }

    @Override
    public void marcarPronto(Pedido pedido) {
        throw new IllegalStateException("Pedido já está pronto");
    }

    @Override
    public void entregar(Pedido pedido) {
        pedido.mudarSituacao(new Entregue(), Pedido.EVENTO_ENTREGUE);
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido pronto não pode ser cancelado");
    }

    @Override
    public String nome() {
        return "PRONTO";
    }
}
