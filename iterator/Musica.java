package padroescomportamentais.iterator;

public class Musica {

    private final String titulo;
    private final String artista;

    public Musica(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String descricao() {
        return titulo + " - " + artista;
    }
}
