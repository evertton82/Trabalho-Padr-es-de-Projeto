package padroesestruturais.decorator;

public class ComChocolate extends BebidaDecorator {

    public ComChocolate(Bebida bebida) {
        super(bebida);
    }

    public String descricao() {
        return bebida.descricao() + " + chocolate";
    }

    public double preco() {
        return bebida.preco() + 2.00;
    }
}
