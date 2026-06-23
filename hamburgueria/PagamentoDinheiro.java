package hamburgueria;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " recebido em dinheiro";
    }

    @Override
    public String nome() {
        return "DINHEIRO";
    }
}
