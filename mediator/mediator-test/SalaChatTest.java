package padroescomportamentais.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaChatTest {

    @Test
    void deveEntregarMensagemAosOutrosUsuarios() {
        SalaChat sala = new SalaChat();
        UsuarioComum joao = new UsuarioComum("João");
        UsuarioComum maria = new UsuarioComum("Maria");
        sala.registrar(joao);
        sala.registrar(maria);

        joao.enviar("Olá pessoal");

        assertEquals(1, maria.getCaixaEntrada().size());
        assertEquals("João: Olá pessoal", maria.getCaixaEntrada().get(0));
    }

    @Test
    void remetenteNaoDeveReceberSuaPropriaMensagem() {
        SalaChat sala = new SalaChat();
        UsuarioComum joao = new UsuarioComum("João");
        UsuarioComum maria = new UsuarioComum("Maria");
        sala.registrar(joao);
        sala.registrar(maria);

        joao.enviar("Olá");

        assertTrue(joao.getCaixaEntrada().isEmpty());
    }

    @Test
    void deveEntregarMensagemParaVariosUsuarios() {
        SalaChat sala = new SalaChat();
        UsuarioComum joao = new UsuarioComum("João");
        UsuarioComum maria = new UsuarioComum("Maria");
        UsuarioComum pedro = new UsuarioComum("Pedro");
        sala.registrar(joao);
        sala.registrar(maria);
        sala.registrar(pedro);

        joao.enviar("Bom dia");

        assertEquals("João: Bom dia", maria.getCaixaEntrada().get(0));
        assertEquals("João: Bom dia", pedro.getCaixaEntrada().get(0));
    }

    @Test
    void deveSuportarConversaBidirecional() {
        SalaChat sala = new SalaChat();
        UsuarioComum joao = new UsuarioComum("João");
        UsuarioComum maria = new UsuarioComum("Maria");
        sala.registrar(joao);
        sala.registrar(maria);

        joao.enviar("Tudo bem?");
        maria.enviar("Tudo sim");

        assertEquals("João: Tudo bem?", maria.getCaixaEntrada().get(0));
        assertEquals("Maria: Tudo sim", joao.getCaixaEntrada().get(0));
    }
}
