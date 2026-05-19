package clinicaveterinaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    private Atendimento novoAtendimento() {
        Tutor tutor = new Tutor("João");
        Animal animal = new Animal("Rex", "Cachorro", false);
        ServicoVeterinario servico = new Consulta(100.00);
        return new Atendimento(tutor, animal, servico);
    }

    // ===================== State - mudanças válidas =====================

    @Test
    void atendimentoDeveComecarAgendado() {
        Atendimento atendimento = novoAtendimento();
        assertEquals("AGENDADO", atendimento.situacaoAtual());
    }

    @Test
    void deveTransitarDeAgendadoParaEmAtendimento() {
        Atendimento atendimento = novoAtendimento();
        atendimento.iniciar();
        assertEquals("EM_ATENDIMENTO", atendimento.situacaoAtual());
    }

    @Test
    void deveTransitarDeEmAtendimentoParaFinalizado() {
        Atendimento atendimento = novoAtendimento();
        atendimento.iniciar();
        atendimento.finalizar();
        assertEquals("FINALIZADO", atendimento.situacaoAtual());
    }

    @Test
    void deveTransitarDeAgendadoParaCancelado() {
        Atendimento atendimento = novoAtendimento();
        atendimento.cancelar();
        assertEquals("CANCELADO", atendimento.situacaoAtual());
    }

    // ===================== State - mudanças inválidas =====================

    @Test
    void naoDeveFinalizarAtendimentoAgendado() {
        Atendimento atendimento = novoAtendimento();
        assertThrows(IllegalStateException.class, atendimento::finalizar);
    }

    @Test
    void naoDeveCancelarAtendimentoEmAndamento() {
        Atendimento atendimento = novoAtendimento();
        atendimento.iniciar();
        assertThrows(IllegalStateException.class, atendimento::cancelar);
    }

    @Test
    void naoDeveCancelarAtendimentoFinalizado() {
        Atendimento atendimento = novoAtendimento();
        atendimento.iniciar();
        atendimento.finalizar();
        assertThrows(IllegalStateException.class, atendimento::cancelar);
    }

    @Test
    void naoDeveAlterarAtendimentoCancelado() {
        Atendimento atendimento = novoAtendimento();
        atendimento.cancelar();
        assertThrows(IllegalStateException.class, atendimento::iniciar);
        assertThrows(IllegalStateException.class, atendimento::finalizar);
        assertThrows(IllegalStateException.class, atendimento::cancelar);
    }

    // ===================== Observer - avisos automáticos =====================

    @Test
    void deveAvisarTutorQuandoAtendimentoForIniciado() {
        Atendimento atendimento = novoAtendimento();
        AvisoTutor avisoTutor = new AvisoTutor();
        atendimento.adicionarObservador(avisoTutor);

        atendimento.iniciar();

        assertEquals(1, avisoTutor.getAvisosRecebidos().size());
        assertEquals("Olá João, o atendimento de Rex foi iniciado",
                avisoTutor.getAvisosRecebidos().get(0));
    }

    @Test
    void deveAvisarVeterinarioQuandoAtendimentoForCancelado() {
        Atendimento atendimento = novoAtendimento();
        AvisoVeterinario avisoVet = new AvisoVeterinario();
        atendimento.adicionarObservador(avisoVet);

        atendimento.cancelar();

        assertEquals(1, avisoVet.getAvisosRecebidos().size());
        assertEquals("Veterinário avisado: atendimento de Rex foi cancelado",
                avisoVet.getAvisosRecebidos().get(0));
    }

    @Test
    void deveAvisarRecepcaoQuandoAtendimentoForFinalizado() {
        Atendimento atendimento = novoAtendimento();
        AvisoRecepcao avisoRecepcao = new AvisoRecepcao();
        atendimento.adicionarObservador(avisoRecepcao);

        atendimento.iniciar();
        atendimento.finalizar();

        assertEquals(1, avisoRecepcao.getAvisosRecebidos().size());
        assertEquals("Recepção avisada: atendimento de Rex foi finalizado",
                avisoRecepcao.getAvisosRecebidos().get(0));
    }

    @Test
    void deveNotificarTodosObservadoresRegistrados() {
        Atendimento atendimento = novoAtendimento();
        AvisoTutor avisoTutor = new AvisoTutor();
        AvisoVeterinario avisoVet = new AvisoVeterinario();
        AvisoRecepcao avisoRecepcao = new AvisoRecepcao();
        atendimento.adicionarObservador(avisoTutor);
        atendimento.adicionarObservador(avisoVet);
        atendimento.adicionarObservador(avisoRecepcao);

        atendimento.iniciar();
        atendimento.finalizar();

        assertEquals(1, avisoTutor.getAvisosRecebidos().size());
        assertEquals(0, avisoVet.getAvisosRecebidos().size());
        assertEquals(1, avisoRecepcao.getAvisosRecebidos().size());
    }

    // ===================== Decorator - cálculo do valor =====================

    @Test
    void valorDaConsultaPuraDeveSerOValorBase() {
        ServicoVeterinario servico = new Consulta(100.00);
        assertEquals(100.00, servico.valor());
        assertEquals("Consulta", servico.descricao());
    }

    @Test
    void deveAplicarDescontoParaAnimalAdotado() {
        ServicoVeterinario servico = new DescontoAnimalAdotado(new Consulta(100.00));
        assertEquals(90.00, servico.valor());
        assertEquals("Consulta + desconto animal adotado", servico.descricao());
    }

    @Test
    void deveAplicarTaxaDomiciliar() {
        ServicoVeterinario servico = new TaxaAtendimentoDomiciliar(new Consulta(100.00));
        assertEquals(150.00, servico.valor());
        assertEquals("Consulta + taxa domiciliar", servico.descricao());
    }

    @Test
    void deveCalcularValorComMultiplasRegrasAplicadas() {
        // Consulta (100) + desconto adotado (-10%) = 90
        // + taxa domiciliar (+50) = 140
        // + banho pós-consulta (+30) = 170
        ServicoVeterinario servico = new BanhoPosConsulta(
                new TaxaAtendimentoDomiciliar(
                        new DescontoAnimalAdotado(
                                new Consulta(100.00))));

        assertEquals(170.00, servico.valor());
        assertEquals("Consulta + desconto animal adotado + taxa domiciliar + banho pós-consulta",
                servico.descricao());
    }

    @Test
    void valorFinalDoAtendimentoDeveRefletirOsDecorators() {
        Tutor tutor = new Tutor("Maria");
        Animal animal = new Animal("Luna", "Gato", true);
        ServicoVeterinario servico = new BanhoPosConsulta(
                new DescontoAnimalAdotado(
                        new Consulta(200.00)));
        Atendimento atendimento = new Atendimento(tutor, animal, servico);

        // 200 - 10% = 180; 180 + 30 = 210
        assertEquals(210.00, atendimento.valorFinal());
    }
}
