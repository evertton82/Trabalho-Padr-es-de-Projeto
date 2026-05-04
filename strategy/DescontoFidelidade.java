package padroescomportamentais.strategy;

public class DescontoFidelidade implements EstrategiaDesconto {

    public double calcular(double valorTotal) {
        return valorTotal * 0.90;
    }
}
