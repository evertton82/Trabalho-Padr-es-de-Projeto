package padroescriacao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    void deveConstruirPizzaMargherita() {
        Pizzaria pizzaria = new Pizzaria();
        Pizza pizza = pizzaria.fazerPizza(new PizzaMargheritaBuilder());

        assertEquals("fina", pizza.getMassa());
        assertEquals("tomate", pizza.getMolho());
        assertTrue(pizza.getIngredientes().contains("mussarela"));
        assertTrue(pizza.getIngredientes().contains("manjericão"));
    }

    @Test
    void deveConstruirPizzaCalabresa() {
        Pizzaria pizzaria = new Pizzaria();
        Pizza pizza = pizzaria.fazerPizza(new PizzaCalabresaBuilder());

        assertEquals("grossa", pizza.getMassa());
        assertEquals("tomate apimentado", pizza.getMolho());
        assertTrue(pizza.getIngredientes().contains("calabresa"));
        assertTrue(pizza.getIngredientes().contains("cebola"));
    }

    @Test
    void deveDescreverPizzaMargheritaCorretamente() {
        Pizzaria pizzaria = new Pizzaria();
        Pizza pizza = pizzaria.fazerPizza(new PizzaMargheritaBuilder());

        assertEquals(
            "Pizza de massa fina, molho de tomate, ingredientes: mussarela, manjericão, tomate fresco",
            pizza.descricao()
        );
    }

    @Test
    void deveProduzirPizzasIndependentesAcadaChamada() {
        Pizzaria pizzaria = new Pizzaria();
        PizzaMargheritaBuilder builder = new PizzaMargheritaBuilder();
        Pizza primeira = pizzaria.fazerPizza(builder);
        Pizza segunda = pizzaria.fazerPizza(builder);

        assertNotSame(primeira, segunda);
        assertEquals(primeira.getIngredientes().size(), segunda.getIngredientes().size());
    }
}
