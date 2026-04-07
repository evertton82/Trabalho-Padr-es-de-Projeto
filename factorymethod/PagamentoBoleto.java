package padroescriacao.factorymethod;

public class PagamentoBoleto implements IPagamento {

    public String pagar() {
        return "Pagamento com boleto efetivado";
    }

    public String cancelar() {
        return "Pagamento com boleto cancelado";
    }
}
