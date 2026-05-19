package padroescomportamentais.memento;

public class EditorMemento {

    private final String conteudo;

    public EditorMemento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return this.conteudo;
    }
}
