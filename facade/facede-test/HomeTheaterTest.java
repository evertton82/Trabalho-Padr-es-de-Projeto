package padroesestruturais.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeTheaterTest {

    private Projetor projetor;
    private SistemaSom som;
    private Luzes luzes;
    private HomeTheaterFacade facade;

    @BeforeEach
    void montarSistema() {
        this.projetor = new Projetor();
        this.som = new SistemaSom();
        this.luzes = new Luzes();
        this.facade = new HomeTheaterFacade(projetor, som, luzes);
    }

    @Test
    void iniciarFilmeDeveLigarProjetorESom() {
        facade.iniciarFilme();

        assertTrue(projetor.estaLigado());
        assertTrue(som.estaLigado());
    }

    @Test
    void iniciarFilmeDeveDiminuirLuzes() {
        facade.iniciarFilme();

        assertEquals(20, luzes.getIntensidade());
    }

    @Test
    void iniciarFilmeDeveAjustarVolume() {
        facade.iniciarFilme();

        assertEquals(7, som.getVolume());
    }

    @Test
    void encerrarFilmeDeveDesligarProjetorESom() {
        facade.iniciarFilme();
        facade.encerrarFilme();

        assertFalse(projetor.estaLigado());
        assertFalse(som.estaLigado());
    }

    @Test
    void encerrarFilmeDeveRestabelecerLuzes() {
        facade.iniciarFilme();
        facade.encerrarFilme();

        assertEquals(100, luzes.getIntensidade());
    }

    @Test
    void iniciarFilmeDeveRetornarLogDeOperacoes() {
        String log = facade.iniciarFilme();

        assertTrue(log.contains("Luzes em 20%"));
        assertTrue(log.contains("Projetor ligado"));
        assertTrue(log.contains("Som ligado"));
        assertTrue(log.contains("Volume ajustado para 7"));
    }
}
