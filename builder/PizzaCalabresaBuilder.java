package padroescriacao.builder;

public class PizzaCalabresaBuilder extends PizzaBuilder {

    public void prepararMassa() {
        this.pizza.setMassa("grossa");
    }

    public void adicionarMolho() {
        this.pizza.setMolho("tomate apimentado");
    }

    public void adicionarIngredientes() {
        this.pizza.adicionarIngrediente("calabresa");
        this.pizza.adicionarIngrediente("cebola");
        this.pizza.adicionarIngrediente("azeitona");
    }
}
