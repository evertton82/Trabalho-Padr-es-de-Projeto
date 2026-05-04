package padroesestruturais.decorator;

public class ComChantilly extends BebidaDecorator {

    public ComChantilly(Bebida bebida) {
        super(bebida);
    }

    public String descricao() {
        return bebida.descricao() + " + chantilly";
    }

    public double preco() {
        return bebida.preco() + 2.50;
    }
}
