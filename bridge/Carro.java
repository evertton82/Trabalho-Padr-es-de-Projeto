package padroesestruturais.bridge;

public class Carro extends Veiculo {

    public Carro(float precoBase) {
        super(precoBase);
    }

    public float calcularCusto() {
        return this.precoBase * (1 + this.combustivel.percentualCusto());
    }
}
