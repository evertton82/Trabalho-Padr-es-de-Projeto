package padroesestruturais.bridge;

public abstract class Veiculo {

    protected Combustivel combustivel;

    protected float precoBase;

    public Veiculo(float precoBase) {
        this.precoBase = precoBase;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public abstract float calcularCusto();
}
