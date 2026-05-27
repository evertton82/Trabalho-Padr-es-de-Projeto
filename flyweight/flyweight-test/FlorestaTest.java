package padroesestruturais.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlorestaTest {

    @Test
    void deveCompartilharMesmoTipoEntreArvoresDaMesmaEspecie() {
        Floresta floresta = new Floresta();
        floresta.plantar(1, 1, "Ipê", "lisa", "amarelo");
        floresta.plantar(5, 7, "Ipê", "lisa", "amarelo");
        floresta.plantar(9, 2, "Ipê", "lisa", "amarelo");

        assertEquals(3, floresta.quantidadeArvores());
        assertEquals(1, floresta.quantidadeTipos());
        assertSame(floresta.getArvores().get(0).getTipo(), floresta.getArvores().get(1).getTipo());
    }

    @Test
    void deveCriarTiposDiferentesParaEspeciesDiferentes() {
        Floresta floresta = new Floresta();
        floresta.plantar(0, 0, "Ipê", "lisa", "amarelo");
        floresta.plantar(0, 0, "Pau-brasil", "rugosa", "vermelho");
        floresta.plantar(0, 0, "Jacarandá", "rugosa", "roxo");

        assertEquals(3, floresta.quantidadeTipos());
    }

    @Test
    void cadaArvoreDeveTerPosicaoPropria() {
        Floresta floresta = new Floresta();
        floresta.plantar(1, 2, "Ipê", "lisa", "amarelo");
        floresta.plantar(8, 9, "Ipê", "lisa", "amarelo");

        assertEquals("Ipê(amarelo) em (1,2)", floresta.desenhar().get(0));
        assertEquals("Ipê(amarelo) em (8,9)", floresta.desenhar().get(1));
    }
}
