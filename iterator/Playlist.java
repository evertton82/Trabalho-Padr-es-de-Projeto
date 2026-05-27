package padroescomportamentais.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Musica> musicas = new ArrayList<>();

    public void adicionar(Musica musica) {
        this.musicas.add(musica);
    }

    public int tamanho() {
        return this.musicas.size();
    }

    public Iterador<Musica> iterador() {
        return new IteradorPlaylist(this.musicas);
    }
}
