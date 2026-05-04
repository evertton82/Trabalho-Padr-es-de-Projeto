package padroescomportamentais.observer;

public class Assinante implements Observador {

    private final String nome;
    private String ultimaNoticiaRecebida;

    public Assinante(String nome) {
        this.nome = nome;
    }

    public void atualizar(String noticia) {
        this.ultimaNoticiaRecebida = noticia;
    }

    public String getNome() {
        return this.nome;
    }

    public String getUltimaNoticiaRecebida() {
        return this.ultimaNoticiaRecebida;
    }
}
