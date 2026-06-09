package padroescomportamentais.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretadorProgramaTest {

    @Test
    void deveAvancarParaNorte() {
        Robo robo = new Robo();
        new Avancar().interpretar(robo);
        assertEquals("(0, 1) N", robo.posicao());
    }

    @Test
    void deveGirarParaLeste() {
        Robo robo = new Robo();
        new Girar().interpretar(robo);
        assertEquals('L', robo.getDirecao());
    }

    @Test
    void deveInterpretarProgramaCompleto() {
        Robo robo = new Robo();
        IComandoRobo programa = new InterpretadorPrograma("A A G A");
        programa.interpretar(robo);
        assertEquals("(1, 2) L", robo.posicao());
    }

    @Test
    void deveRetornarExcecaoComandoInvalido() {
        try {
            new InterpretadorPrograma("A X");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Comando inválido: X", e.getMessage());
        }
    }
}
