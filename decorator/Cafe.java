package padroesestruturais.decorator;

public class Cafe implements Bebida {

    public String descricao() {
        return "Café";
    }

    public double preco() {
        return 5.00;
    }
}
