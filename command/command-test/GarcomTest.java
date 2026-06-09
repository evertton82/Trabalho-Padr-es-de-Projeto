package padroescomportamentais.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GarcomTest {

    Garcom garcom;
    Cozinha cozinha;

    @BeforeEach
    void setUp() {
        garcom = new Garcom();
        cozinha = new Cozinha();
    }

    @Test
    void deveExecutarPedido() {
        String resultado = garcom.anotarEEnviar(new ComandoPrato(cozinha, "Lasanha"));
        assertEquals("Cozinha preparou: Lasanha", resultado);
    }

    @Test
    void deveContarPedidosPendentes() {
        garcom.anotarEEnviar(new ComandoPrato(cozinha, "Salada"));
        garcom.anotarEEnviar(new ComandoPrato(cozinha, "Risoto"));
        assertEquals(2, garcom.pedidosPendentes());
    }

    @Test
    void deveCancelarUltimoPedido() {
        garcom.anotarEEnviar(new ComandoPrato(cozinha, "Salada"));
        garcom.anotarEEnviar(new ComandoPrato(cozinha, "Risoto"));

        String resultado = garcom.cancelarUltimoPedido();

        assertEquals("Cozinha descartou: Risoto", resultado);
        assertEquals(1, garcom.pedidosPendentes());
    }
}
