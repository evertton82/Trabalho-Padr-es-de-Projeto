package hamburgueria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido novoPedido() {
        Cliente cliente = new Cliente("Ana");
        ItemCardapio item = Cardapio.classico();
        return new Pedido(cliente, item);
    }

    // ===================== Builder - montagem do hamburguer =====================

    @Test
    void cardapioDeveMontarHamburguerClassicoComBuilder() {
        ItemCardapio classico = Cardapio.classico();
        assertEquals("Clássico (pão brioche, carne bovina 150g, queijo, alface, tomate)", classico.descricao());
        assertEquals(25.00, classico.preco());
    }

    @Test
    void builderDeveMontarHamburguerCustomizado() {
        Hamburguer hamburguer = new HamburguerBuilder()
                .comNome("Custom")
                .comPao("australiano")
                .comCarne("carne bovina 200g")
                .comIngrediente("queijo")
                .comPrecoBase(30.00)
                .build();

        assertEquals("Custom (pão australiano, carne bovina 200g, queijo)", hamburguer.descricao());
        assertEquals(30.00, hamburguer.preco());
    }

    // ===================== Decorator - adicionais =====================

    @Test
    void deveAdicionarBaconAoItem() {
        ItemCardapio item = new AdicionalBacon(Cardapio.classico());
        assertEquals(31.00, item.preco());
        assertEquals("Clássico (pão brioche, carne bovina 150g, queijo, alface, tomate) + bacon extra",
                item.descricao());
    }

    @Test
    void deveEmpilharVariosAdicionais() {
        ItemCardapio item = new AdicionalMolhoEspecial(
                new AdicionalCheddar(
                        new AdicionalBacon(Cardapio.classico())));

        assertEquals(38.50, item.preco());
        assertEquals("Clássico (pão brioche, carne bovina 150g, queijo, alface, tomate)"
                + " + bacon extra + cheddar extra + molho especial", item.descricao());
    }

    // ===================== State - mudancas validas =====================

    @Test
    void pedidoDeveComecarRecebido() {
        assertEquals("RECEBIDO", novoPedido().situacaoAtual());
    }

    @Test
    void deveTransitarRecebidoParaEmPreparo() {
        Pedido pedido = novoPedido();
        pedido.iniciarPreparo();
        assertEquals("EM_PREPARO", pedido.situacaoAtual());
    }

    @Test
    void deveSeguirFluxoCompletoAteEntregue() {
        Pedido pedido = novoPedido();
        pedido.iniciarPreparo();
        pedido.marcarPronto();
        pedido.entregar();
        assertEquals("ENTREGUE", pedido.situacaoAtual());
    }

    @Test
    void deveCancelarPedidoRecebido() {
        Pedido pedido = novoPedido();
        pedido.cancelar();
        assertEquals("CANCELADO", pedido.situacaoAtual());
    }

    // ===================== State - mudancas invalidas =====================

    @Test
    void naoDeveEntregarPedidoRecebido() {
        assertThrows(IllegalStateException.class, novoPedido()::entregar);
    }

    @Test
    void naoDeveCancelarPedidoEmPreparo() {
        Pedido pedido = novoPedido();
        pedido.iniciarPreparo();
        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    @Test
    void naoDeveAlterarPedidoEntregue() {
        Pedido pedido = novoPedido();
        pedido.iniciarPreparo();
        pedido.marcarPronto();
        pedido.entregar();
        assertThrows(IllegalStateException.class, pedido::iniciarPreparo);
        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    @Test
    void naoDeveAlterarPedidoCancelado() {
        Pedido pedido = novoPedido();
        pedido.cancelar();
        assertThrows(IllegalStateException.class, pedido::iniciarPreparo);
        assertThrows(IllegalStateException.class, pedido::entregar);
        assertThrows(IllegalStateException.class, pedido::cancelar);
    }

    // ===================== Observer - avisos automaticos =====================

    @Test
    void deveAvisarPainelCozinhaQuandoIniciarPreparo() {
        Pedido pedido = novoPedido();
        PainelCozinha painel = new PainelCozinha();
        pedido.adicionarObservador(painel);

        pedido.iniciarPreparo();

        assertEquals(1, painel.getMensagens().size());
        assertEquals("Cozinha: preparar Clássico (pão brioche, carne bovina 150g, queijo, alface, tomate)",
                painel.getMensagens().get(0));
    }

    @Test
    void deveAvisarClienteQuandoPedidoFicarPronto() {
        Pedido pedido = novoPedido();
        AvisoCliente aviso = new AvisoCliente();
        pedido.adicionarObservador(aviso);

        pedido.iniciarPreparo();
        pedido.marcarPronto();

        assertEquals(1, aviso.getMensagens().size());
        assertEquals("Ana, seu pedido está pronto!", aviso.getMensagens().get(0));
    }

    @Test
    void deveRegistrarCancelamentoNoGerencial() {
        Pedido pedido = novoPedido();
        RegistroGerencial registro = new RegistroGerencial();
        pedido.adicionarObservador(registro);

        pedido.cancelar();

        assertEquals(1, registro.getMensagens().size());
        assertEquals("Gerência: pedido de Ana cancelado", registro.getMensagens().get(0));
    }

    @Test
    void deveNotificarApenasObservadoresInteressadosEmCadaEvento() {
        Pedido pedido = novoPedido();
        PainelCozinha painel = new PainelCozinha();
        AvisoCliente aviso = new AvisoCliente();
        RegistroGerencial registro = new RegistroGerencial();
        pedido.adicionarObservador(painel);
        pedido.adicionarObservador(aviso);
        pedido.adicionarObservador(registro);

        pedido.iniciarPreparo();
        pedido.marcarPronto();
        pedido.entregar();

        assertEquals(1, painel.getMensagens().size());
        assertEquals(1, aviso.getMensagens().size());
        assertEquals(1, registro.getMensagens().size());
    }

    // ===================== Strategy - formas de pagamento =====================

    @Test
    void totalDoPedidoDeveRefletirOsAdicionais() {
        Cliente cliente = new Cliente("Bia");
        ItemCardapio item = new AdicionalBacon(Cardapio.classico());
        Pedido pedido = new Pedido(cliente, item);
        assertEquals(31.00, pedido.total());
    }

    @Test
    void devePagarComPix() {
        Pedido pedido = novoPedido();
        pedido.definirFormaPagamento(new PagamentoPix());
        assertTrue(pedido.pagar().contains("PIX"));
    }

    @Test
    void deveTrocarEstrategiaDePagamentoEmTempoDeExecucao() {
        Pedido pedido = novoPedido();

        pedido.definirFormaPagamento(new PagamentoDinheiro());
        assertTrue(pedido.pagar().contains("dinheiro"));

        pedido.definirFormaPagamento(new PagamentoCartao());
        assertTrue(pedido.pagar().contains("cartão"));
    }

    @Test
    void naoDevePagarSemFormaDefinida() {
        assertThrows(IllegalStateException.class, novoPedido()::pagar);
    }

    // ===================== Factory Method - criacao de hamburgueres =====================

    @Test
    void fabricaClassicoDeveCriarHamburguerClassico() {
        Hamburguer hamburguer = new FabricaClassico().criar();
        assertEquals("Clássico (pão brioche, carne bovina 150g, queijo, alface, tomate)", hamburguer.descricao());
        assertEquals(25.00, hamburguer.preco());
    }

    @Test
    void cardapioDeveDelegarParaAFabrica() {
        assertEquals(new FabricaVegano().criar().descricao(), Cardapio.vegano().descricao());
        assertEquals(new FabricaDuploBacon().criar().preco(), Cardapio.duploBacon().preco());
    }

    // ===================== Composite - combos =====================

    @Test
    void comboDeveSomarOPrecoDosItens() {
        Combo combo = new Combo("Combo Clássico")
                .adicionar(Cardapio.classico())
                .adicionar(new Acompanhamento("Batata frita", 12.00))
                .adicionar(new Acompanhamento("Refrigerante", 8.00));

        assertEquals(45.00, combo.preco());
        assertTrue(combo.descricao().contains("Batata frita"));
        assertTrue(combo.descricao().contains("Refrigerante"));
    }

    @Test
    void comboDeveAceitarItemDecorado() {
        Combo combo = new Combo("Combo Bacon")
                .adicionar(new AdicionalBacon(Cardapio.classico()))
                .adicionar(new Acompanhamento("Refrigerante", 8.00));

        assertEquals(39.00, combo.preco());
    }

    @Test
    void comboPodeConterOutroCombo() {
        Combo bebidas = new Combo("Bebidas")
                .adicionar(new Acompanhamento("Refrigerante", 8.00))
                .adicionar(new Acompanhamento("Suco", 9.00));
        Combo familia = new Combo("Combo Família")
                .adicionar(Cardapio.classico())
                .adicionar(Cardapio.vegano())
                .adicionar(bebidas);

        assertEquals(70.00, familia.preco());
    }

    // ===================== Facade - Lanchonete =====================

    @Test
    void lanchoneteDeveOrquestrarPedidoCompleto() {
        Lanchonete lanchonete = new Lanchonete();
        Pedido pedido = lanchonete.registrarPedido(new Cliente("Ana"), Cardapio.classico());
        assertEquals("RECEBIDO", pedido.situacaoAtual());

        String recibo = lanchonete.finalizar(pedido, new PagamentoPix());

        assertEquals("ENTREGUE", pedido.situacaoAtual());
        assertTrue(recibo.contains("PIX"));
    }

    // ===================== Adapter - gateway externo =====================

    @Test
    void adaptadorDeveConverterChamadaParaOGatewayExterno() {
        FormaPagamento forma = new AdaptadorGateway(new GatewayPagamentoExterno());
        String recibo = forma.pagar(31.00);
        assertTrue(recibo.contains("3100"));
        assertTrue(recibo.contains("BRL"));
    }

    @Test
    void pedidoDevePagarUsandoOAdaptador() {
        Pedido pedido = novoPedido();
        pedido.definirFormaPagamento(new AdaptadorGateway(new GatewayPagamentoExterno()));
        assertTrue(pedido.pagar().contains("autorizado"));
    }
}
