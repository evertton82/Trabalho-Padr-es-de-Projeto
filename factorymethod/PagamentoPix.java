package padroescriacao.factorymethod;

public class PagamentoPix implements IPagamento {

    public String pagar() {
        return "Pagamento com Pix efetivado";
    }

    public String cancelar() {
        return "Pagamento com Pix cancelado";
    }
}
