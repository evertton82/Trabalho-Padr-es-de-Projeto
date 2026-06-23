package hamburgueria;

public class Recebido implements SituacaoPedido {

    @Override
    public void iniciarPreparo(Pedido pedido) {
        pedido.mudarSituacao(new EmPreparo(), Pedido.EVENTO_EM_PREPARO);
    }

    @Override
    public void marcarPronto(Pedido pedido) {
        throw new IllegalStateException("Pedido recebido precisa entrar em preparo antes de ficar pronto");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido recebido não pode ser entregue");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.mudarSituacao(new Cancelado(), Pedido.EVENTO_CANCELADO);
    }

    @Override
    public String nome() {
        return "RECEBIDO";
    }
}
