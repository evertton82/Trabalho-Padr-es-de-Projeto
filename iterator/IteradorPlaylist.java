package padroescomportamentais.iterator;

import java.util.List;

public class IteradorPlaylist implements Iterador<Musica> {

    private final List<Musica> musicas;
    private int posicao;

    public IteradorPlaylist(List<Musica> musicas) {
        this.musicas = musicas;
        this.posicao = 0;
    }

    public boolean temProximo() {
        return posicao < musicas.size();
    }

    public Musica proximo() {
        Musica musica = musicas.get(posicao);
        posicao++;
        return musica;
    }
}
