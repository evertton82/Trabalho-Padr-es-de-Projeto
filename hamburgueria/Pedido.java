package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public static final String EVENTO_EM_PREPARO = "EM_PREPARO";
    public static final String EVENTO_PRONTO = "PRONTO";
    public static final String EVENTO_ENTREGUE = "ENTREGUE";
    public static final String EVENTO_CANCELADO = "CANCELADO";

    private final Cliente cliente;
    private final ItemCardapio item;
    private SituacaoPedido situacao;
    private FormaPagamento formaPagamento;
    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public Pedido(Cliente cliente, ItemCardapio item) {
        this.cliente = cliente;
        this.item = item;
        this.situacao = new Recebido();
    }

    public void adicionarObservador(ObservadorPedido observador) {
        this.observadores.add(observador);
    }

    public void removerObservador(ObservadorPedido observador) {
        this.observadores.remove(observador);
    }

    public void iniciarPreparo() {
        this.situacao.iniciarPreparo(this);
    }

    public void marcarPronto() {
        this.situacao.marcarPronto(this);
    }

    public void entregar() {
        this.situacao.entregar(this);
    }

    public void cancelar() {
        this.situacao.cancelar(this);
    }

    public void mudarSituacao(SituacaoPedido novaSituacao, String evento) {
        this.situacao = novaSituacao;
        notificarTodos(evento);
    }

    public void notificarTodos(String evento) {
        for (ObservadorPedido observador : this.observadores) {
            observador.notificar(this, evento);
        }
    }

    public String situacaoAtual() {
        return this.situacao.nome();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double total() {
        return this.item.preco();
    }

    public String descricaoItem() {
        return this.item.descricao();
    }

    public void definirFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String pagar() {
        if (this.formaPagamento == null) {
            throw new IllegalStateException("Forma de pagamento não definida");
        }
        return this.formaPagamento.pagar(total());
    }
}
