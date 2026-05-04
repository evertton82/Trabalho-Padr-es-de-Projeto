package padroescomportamentais.strategy;

public class SemDesconto implements EstrategiaDesconto {

    public double calcular(double valorTotal) {
        return valorTotal;
    }
}
