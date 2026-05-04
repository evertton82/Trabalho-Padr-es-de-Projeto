package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanalNoticiasTest {

    @Test
    void deveNotificarAssinanteUnico() {
        CanalNoticias canal = new CanalNoticias();
        Assinante joao = new Assinante("João");
        canal.registrar(joao);

        canal.publicar("Brasil vence a copa");

        assertEquals("Brasil vence a copa", joao.getUltimaNoticiaRecebida());
    }

    @Test
    void deveNotificarTodosAssinantesRegistrados() {
        CanalNoticias canal = new CanalNoticias();
        Assinante joao = new Assinante("João");
        Assinante maria = new Assinante("Maria");
        canal.registrar(joao);
        canal.registrar(maria);

        canal.publicar("Nova vacina aprovada");

        assertEquals("Nova vacina aprovada", joao.getUltimaNoticiaRecebida());
        assertEquals("Nova vacina aprovada", maria.getUltimaNoticiaRecebida());
    }

    @Test
    void naoDeveNotificarAssinanteRemovido() {
        CanalNoticias canal = new CanalNoticias();
        Assinante joao = new Assinante("João");
        Assinante maria = new Assinante("Maria");
        canal.registrar(joao);
        canal.registrar(maria);

        canal.publicar("Primeira manchete");
        canal.remover(maria);
        canal.publicar("Segunda manchete");

        assertEquals("Segunda manchete", joao.getUltimaNoticiaRecebida());
        assertEquals("Primeira manchete", maria.getUltimaNoticiaRecebida());
    }

    @Test
    void deveAtualizarComUltimaNoticiaPublicada() {
        CanalNoticias canal = new CanalNoticias();
        Assinante joao = new Assinante("João");
        canal.registrar(joao);

        canal.publicar("Manchete 1");
        canal.publicar("Manchete 2");

        assertEquals("Manchete 2", joao.getUltimaNoticiaRecebida());
    }
}
