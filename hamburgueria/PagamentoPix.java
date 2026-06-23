package hamburgueria;

public class PagamentoPix implements FormaPagamento {

    @Override
    public String pagar(double valor) {
        return "Pagamento de R$ " + valor + " confirmado via PIX";
    }

    @Override
    public String nome() {
        return "PIX";
    }
}
