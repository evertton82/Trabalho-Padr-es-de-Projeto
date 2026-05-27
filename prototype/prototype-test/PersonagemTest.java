package padroescriacao.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    @Test
    void deveClonarGuerreiroComMesmosValores() {
        Guerreiro original = new Guerreiro("Tibério", 100, 25, "Espada longa");
        Guerreiro copia = (Guerreiro) original.clonar();

        assertEquals("Tibério", copia.getNome());
        assertEquals(100, copia.getVida());
        assertEquals(25, copia.getAtaque());
        assertEquals("Espada longa", copia.getArmaPrincipal());
        assertNotSame(original, copia);
    }

    @Test
    void alteracaoNoCloneNaoDeveAfetarOriginal() {
        Guerreiro original = new Guerreiro("Tibério", 100, 25, "Espada longa");
        Guerreiro copia = (Guerreiro) original.clonar();

        copia.setNome("Aurélio");
        copia.receberDano(30);

        assertEquals("Tibério", original.getNome());
        assertEquals(100, original.getVida());
        assertEquals("Aurélio", copia.getNome());
        assertEquals(70, copia.getVida());
    }

    @Test
    void deveClonarMago() {
        Mago original = new Mago("Eleonora", 70, 40, "Bola de fogo");
        Mago copia = (Mago) original.clonar();

        assertEquals("Eleonora", copia.getNome());
        assertEquals("Bola de fogo", copia.getMagiaPrincipal());
        assertNotSame(original, copia);
    }

    @Test
    void registroDeveDevolverCloneIndependenteDoOriginal() {
        RegistroPersonagens registro = new RegistroPersonagens();
        registro.cadastrar("guerreiro-base", new Guerreiro("Modelo", 100, 20, "Machado"));

        Personagem p1 = registro.criar("guerreiro-base");
        Personagem p2 = registro.criar("guerreiro-base");

        assertNotSame(p1, p2);
        assertEquals("Modelo", p1.getNome());

        p1.setNome("Bruno");
        assertEquals("Modelo", p2.getNome());
    }
}
