package hamburgueria;

public class AdicionalCheddar extends AdicionalDecorator {

    private static final double PRECO = 4.50;

    public AdicionalCheddar(ItemCardapio base) {
        super(base);
    }

    @Override
    public String descricao() {
        return base.descricao() + " + cheddar extra";
    }

    @Override
    public double preco() {
        return base.preco() + PRECO;
    }
}
