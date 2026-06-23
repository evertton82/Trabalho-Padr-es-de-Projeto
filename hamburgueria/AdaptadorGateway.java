package hamburgueria;

public class AdaptadorGateway implements FormaPagamento {

    private final GatewayPagamentoExterno gateway;

    public AdaptadorGateway(GatewayPagamentoExterno gateway) {
        this.gateway = gateway;
    }

    @Override
    public String pagar(double valor) {
        return this.gateway.autorizar(Math.round(valor * 100), "BRL");
    }

    @Override
    public String nome() {
        return "GATEWAY";
    }
}
