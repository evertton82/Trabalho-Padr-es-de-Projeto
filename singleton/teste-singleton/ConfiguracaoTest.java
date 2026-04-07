import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConfiguracaoTest {

    @Test
    public void deveRetornarNomeSistema() {
        Configuracao.getInstance().setNomeSistema("Sistema X");
        assertEquals("Sistema X", Configuracao.getInstance().getNomeSistema());
    }

    @Test
    public void deveRetornarUsuarioLogado() {
        Configuracao.getInstance().setUsuarioLogado("Usuario 1");
        assertEquals("Usuario 1", Configuracao.getInstance().getUsuarioLogado());
    }
}