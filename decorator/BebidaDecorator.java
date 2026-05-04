package padroesestruturais.decorator;

public abstract class BebidaDecorator implements Bebida {

    protected final Bebida bebida;

    protected BebidaDecorator(Bebida bebida) {
        this.bebida = bebida;
    }
}
