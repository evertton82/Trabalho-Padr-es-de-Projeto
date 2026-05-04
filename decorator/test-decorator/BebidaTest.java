package padroesestruturais.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    @Test
    void deveServirCafePuro() {
        Bebida bebida = new Cafe();
        assertEquals("Café", bebida.descricao());
        assertEquals(5.00, bebida.preco());
    }

    @Test
    void deveServirCafeComLeite() {
        Bebida bebida = new ComLeite(new Cafe());
        assertEquals("Café + leite", bebida.descricao());
        assertEquals(6.50, bebida.preco());
    }

    @Test
    void deveServirCafeComLeiteEChocolate() {
        Bebida bebida = new ComChocolate(new ComLeite(new Cafe()));
        assertEquals("Café + leite + chocolate", bebida.descricao());
        assertEquals(8.50, bebida.preco());
    }

    @Test
    void deveServirMochaCompleto() {
        Bebida bebida = new ComChantilly(new ComChocolate(new ComLeite(new Cafe())));
        assertEquals("Café + leite + chocolate + chantilly", bebida.descricao());
        assertEquals(11.00, bebida.preco());
    }
}
