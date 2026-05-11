package padroescriacao.builder;

public class PizzaMargheritaBuilder extends PizzaBuilder {

    public void prepararMassa() {
        this.pizza.setMassa("fina");
    }

    public void adicionarMolho() {
        this.pizza.setMolho("tomate");
    }

    public void adicionarIngredientes() {
        this.pizza.adicionarIngrediente("mussarela");
        this.pizza.adicionarIngrediente("manjericão");
        this.pizza.adicionarIngrediente("tomate fresco");
    }
}
