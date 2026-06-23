package hamburgueria;

public abstract class AdicionalDecorator implements ItemCardapio {

    protected final ItemCardapio base;

    protected AdicionalDecorator(ItemCardapio base) {
        this.base = base;
    }
}
