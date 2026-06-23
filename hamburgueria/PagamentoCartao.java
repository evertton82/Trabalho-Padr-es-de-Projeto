package hamburgueria;

public class PagamentoCartao implements FormaPagamento {

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " aprovado no cartão de crédito";
    }

    @Override
    public String nome() {
        return "CARTÃO";
    }
}
