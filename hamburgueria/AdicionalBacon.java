package hamburgueria;

public class AdicionalBacon extends AdicionalDecorator {

    private static final double PRECO = 6.00;

    public AdicionalBacon(ItemCardapio base) {
        super(base);
    }

    @Override
    public String descricao() {
        return base.descricao() + " + bacon extra";
    }

    @Override
    public double preco() {
        return base.preco() + PRECO;
    }
}
