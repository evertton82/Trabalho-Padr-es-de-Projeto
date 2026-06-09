package padroesestruturais.proxy;

public class DocumentoConfidencial implements IDocumento {

    private final String titulo;
    private final String conteudo;

    public DocumentoConfidencial(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String ler(Usuario usuario) {
        return conteudo;
    }
}
