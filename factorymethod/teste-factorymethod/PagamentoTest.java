package padroescriacao.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void devePagarComCartao() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        assertEquals("Pagamento com cartão efetivado", pagamento.pagar());
    }

    @Test
    void deveCancelarComCartao() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Cartao");
        assertEquals("Pagamento com cartão cancelado", pagamento.cancelar());
    }

    @Test
    void devePagarComPix() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        assertEquals("Pagamento com Pix efetivado", pagamento.pagar());
    }

    @Test
    void deveCancelarComPix() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Pix");
        assertEquals("Pagamento com Pix cancelado", pagamento.cancelar());
    }

    @Test
    void devePagarComBoleto() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        assertEquals("Pagamento com boleto efetivado", pagamento.pagar());
    }

    @Test
    void deveCancelarComBoleto() {
        IPagamento pagamento = PagamentoFactory.obterPagamento("Boleto");
        assertEquals("Pagamento com boleto cancelado", pagamento.cancelar());
    }

    @Test
    void deveLancarExcecaoParaPagamentoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            PagamentoFactory.obterPagamento("Inexistente");
        });
    }
}
