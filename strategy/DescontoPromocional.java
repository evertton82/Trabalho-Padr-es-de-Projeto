package padroescomportamentais.strategy;

public class DescontoPromocional implements EstrategiaDesconto {

    public double calcular(double valorTotal) {
        return valorTotal * 0.75;
    }
}
