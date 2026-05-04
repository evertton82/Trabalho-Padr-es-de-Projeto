package padroescomportamentais.strategy;

public class Carrinho {

    private double valorTotal;
    private EstrategiaDesconto estrategia;

    public Carrinho(EstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
        this.valorTotal = 0.0;
    }

    public void adicionar(double valor) {
        this.valorTotal += valor;
    }

    public void setEstrategia(EstrategiaDesconto estrategia) {
        this.estrategia = estrategia;
    }

    public double total() {
        return this.estrategia.calcular(this.valorTotal);
    }
}
