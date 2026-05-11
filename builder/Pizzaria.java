package padroescriacao.builder;

public class Pizzaria {

    public Pizza fazerPizza(PizzaBuilder builder) {
        builder.novaPizza();
        builder.prepararMassa();
        builder.adicionarMolho();
        builder.adicionarIngredientes();
        return builder.getPizza();
    }
}
