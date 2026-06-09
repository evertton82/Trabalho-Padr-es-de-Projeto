package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProxyDocumentoTest {

    IDocumento documento;

    @BeforeEach
    void setUp() {
        documento = new ProxyDocumento("Plano Estratégico", "Conteúdo confidencial 2026");
    }

    @Test
    void devePermitirLeituraParaUsuarioAutorizado() {
        Usuario usuario = new Usuario("Ana", true);
        assertEquals("Conteúdo confidencial 2026", documento.ler(usuario));
    }

    @Test
    void deveNegarLeituraParaUsuarioNaoAutorizado() {
        try {
            Usuario usuario = new Usuario("Carlos", false);
            documento.ler(usuario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Usuário não autorizado: Carlos", e.getMessage());
        }
    }
}
