package padroescomportamentais.visitor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitanteTest {

    @Test
    void veterinarioDeveAtenderCadaAnimal() {
        Visitante veterinario = new Veterinario();

        assertEquals("Veterinário examina os dentes do leão", new Leao().aceitar(veterinario));
        assertEquals("Veterinário verifica a temperatura do macaco", new Macaco().aceitar(veterinario));
        assertEquals("Veterinário cuida das patas do elefante", new Elefante().aceitar(veterinario));
    }

    @Test
    void tratadorDeveAlimentarCadaAnimal() {
        Visitante tratador = new Tratador();

        assertEquals("Tratador alimenta o leão com 5kg de carne", new Leao().aceitar(tratador));
        assertEquals("Tratador alimenta o macaco com bananas", new Macaco().aceitar(tratador));
        assertEquals("Tratador alimenta o elefante com feno", new Elefante().aceitar(tratador));
    }

    @Test
    void mesmoAnimalDeveAceitarVisitantesDiferentes() {
        Animal leao = new Leao();

        assertEquals("Veterinário examina os dentes do leão", leao.aceitar(new Veterinario()));
        assertEquals("Tratador alimenta o leão com 5kg de carne", leao.aceitar(new Tratador()));
    }

    @Test
    void mesmoVisitanteDevePercorrerColecaoHeterogenea() {
        List<Animal> zoologico = List.of(new Leao(), new Macaco(), new Elefante());
        Visitante tratador = new Tratador();

        StringBuilder relatorio = new StringBuilder();
        for (Animal animal : zoologico) {
            relatorio.append(animal.aceitar(tratador)).append("\n");
        }

        String esperado =
                "Tratador alimenta o leão com 5kg de carne\n" +
                "Tratador alimenta o macaco com bananas\n" +
                "Tratador alimenta o elefante com feno\n";
        assertEquals(esperado, relatorio.toString());
    }
}
