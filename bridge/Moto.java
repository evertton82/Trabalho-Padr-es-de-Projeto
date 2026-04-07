package padroesestruturais.bridge;

public class Moto extends Veiculo {

    public Moto(float precoBase) {
        super(precoBase);
    }

    public float calcularCusto() {
        return this.precoBase * this.combustivel.percentualCusto();
    }
}
