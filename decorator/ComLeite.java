package padroesestruturais.decorator;

public class ComLeite extends BebidaDecorator {

    public ComLeite(Bebida bebida) {
        super(bebida);
    }

    public String descricao() {
        return bebida.descricao() + " + leite";
    }

    public double preco() {
        return bebida.preco() + 1.50;
    }
}
