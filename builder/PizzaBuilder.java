package padroescriacao.builder;

public abstract class PizzaBuilder {

    protected Pizza pizza;

    public void novaPizza() {
        this.pizza = new Pizza();
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public abstract void prepararMassa();
    public abstract void adicionarMolho();
    public abstract void adicionarIngredientes();
}
