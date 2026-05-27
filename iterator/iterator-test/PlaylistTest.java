package padroescomportamentais.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void deveIterarTodasAsMusicasNaOrdem() {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Musica("Garota de Ipanema", "Tom Jobim"));
        playlist.adicionar(new Musica("Aquarela do Brasil", "Ary Barroso"));
        playlist.adicionar(new Musica("Construção", "Chico Buarque"));

        Iterador<Musica> it = playlist.iterador();
        assertTrue(it.temProximo());
        assertEquals("Garota de Ipanema", it.proximo().getTitulo());
        assertEquals("Aquarela do Brasil", it.proximo().getTitulo());
        assertEquals("Construção", it.proximo().getTitulo());
        assertFalse(it.temProximo());
    }

    @Test
    void deveIterarPlaylistVazia() {
        Playlist playlist = new Playlist();
        Iterador<Musica> it = playlist.iterador();
        assertFalse(it.temProximo());
    }

    @Test
    void cadaIteradorDeveSerIndependente() {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Musica("Asa Branca", "Luiz Gonzaga"));
        playlist.adicionar(new Musica("Eduardo e Mônica", "Legião Urbana"));

        Iterador<Musica> it1 = playlist.iterador();
        Iterador<Musica> it2 = playlist.iterador();

        it1.proximo();
        assertEquals("Asa Branca", it2.proximo().getTitulo());
    }
}
