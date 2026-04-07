package padroescriacao.factorymethod;

public class PagamentoCartao implements IPagamento {

    public String pagar() {
        return "Pagamento com cartão efetivado";
    }

    public String cancelar() {
        return "Pagamento com cartão cancelado";
    }
}
