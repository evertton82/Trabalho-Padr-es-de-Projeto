package padroescomportamentais.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    @Test
    void deveCalcularTotalSemDesconto() {
        Carrinho carrinho = new Carrinho(new SemDesconto());
        carrinho.adicionar(100.00);
        carrinho.adicionar(50.00);
        assertEquals(150.00, carrinho.total());
    }

    @Test
    void deveAplicarDescontoFidelidade() {
        Carrinho carrinho = new Carrinho(new DescontoFidelidade());
        carrinho.adicionar(200.00);
        assertEquals(180.00, carrinho.total());
    }

    @Test
    void deveAplicarDescontoPromocional() {
        Carrinho carrinho = new Carrinho(new DescontoPromocional());
        carrinho.adicionar(200.00);
        assertEquals(150.00, carrinho.total());
    }

    @Test
    void deveTrocarEstrategiaEmTempoDeExecucao() {
        Carrinho carrinho = new Carrinho(new SemDesconto());
        carrinho.adicionar(100.00);
        assertEquals(100.00, carrinho.total());

        carrinho.setEstrategia(new DescontoFidelidade());
        assertEquals(90.00, carrinho.total());

        carrinho.setEstrategia(new DescontoPromocional());
        assertEquals(75.00, carrinho.total());
    }
}
