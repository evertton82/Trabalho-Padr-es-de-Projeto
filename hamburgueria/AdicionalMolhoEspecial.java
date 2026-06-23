package hamburgueria;

public class AdicionalMolhoEspecial extends AdicionalDecorator {

    private static final double PRECO = 3.00;

    public AdicionalMolhoEspecial(ItemCardapio base) {
        super(base);
    }

    @Override
    public String descricao() {
        return base.descricao() + " + molho especial";
    }

    @Override
    public double preco() {
        return base.preco() + PRECO;
    }
}
