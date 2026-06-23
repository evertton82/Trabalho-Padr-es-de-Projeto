package hamburgueria;

public class GatewayPagamentoExterno {

    public String autorizar(long valorEmCentavos, String moeda) {
        return "Gateway externo: " + valorEmCentavos + " " + moeda + " autorizado";
    }
}
