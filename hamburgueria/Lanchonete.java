package hamburgueria;

public class Lanchonete {

    public Pedido registrarPedido(Cliente cliente, ItemCardapio item) {
        Pedido pedido = new Pedido(cliente, item);
        pedido.adicionarObservador(new PainelCozinha());
        pedido.adicionarObservador(new AvisoCliente());
        pedido.adicionarObservador(new RegistroGerencial());
        return pedido;
    }

    public String finalizar(Pedido pedido, FormaPagamento formaPagamento) {
        pedido.iniciarPreparo();
        pedido.marcarPronto();
        pedido.entregar();
        pedido.definirFormaPagamento(formaPagamento);
        return pedido.pagar();
    }
}
