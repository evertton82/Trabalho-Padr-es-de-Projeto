package padroescomportamentais.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void pedidoDeveComecarNoEstadoNovo() {
        Pedido pedido = new Pedido();
        assertEquals("NOVO", pedido.estadoAtual());
    }

    @Test
    void deveTransitarDeNovoParaPago() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        assertEquals("PAGO", pedido.estadoAtual());
    }

    @Test
    void deveTransitarDePagoParaEnviado() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviar();
        assertEquals("ENVIADO", pedido.estadoAtual());
    }

    @Test
    void deveTransitarDeEnviadoParaEntregue() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        assertEquals("ENTREGUE", pedido.estadoAtual());
    }

    @Test
    void naoDeveEnviarPedidoNovo() {
        Pedido pedido = new Pedido();
        assertThrows(IllegalStateException.class, pedido::enviar);
    }

    @Test
    void naoDeveEntregarPedidoNovo() {
        Pedido pedido = new Pedido();
        assertThrows(IllegalStateException.class, pedido::entregar);
    }

    @Test
    void naoDevePagarPedidoJaPago() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        assertThrows(IllegalStateException.class, pedido::pagar);
    }

    @Test
    void naoDeveAlterarPedidoEntregue() {
        Pedido pedido = new Pedido();
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();

        assertThrows(IllegalStateException.class, pedido::pagar);
        assertThrows(IllegalStateException.class, pedido::enviar);
        assertThrows(IllegalStateException.class, pedido::entregar);
    }
}
