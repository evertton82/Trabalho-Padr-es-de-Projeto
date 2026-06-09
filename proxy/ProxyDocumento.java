package padroesestruturais.proxy;

public class ProxyDocumento implements IDocumento {

    private DocumentoConfidencial documento;
    private final String titulo;
    private final String conteudo;

    public ProxyDocumento(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    @Override
    public String ler(Usuario usuario) {
        if (!usuario.isAutorizado()) {
            throw new IllegalArgumentException("Usuário não autorizado: " + usuario.getNome());
        }
        if (this.documento == null) {
            this.documento = new DocumentoConfidencial(this.titulo, this.conteudo);
        }
        return this.documento.ler(usuario);
    }
}
