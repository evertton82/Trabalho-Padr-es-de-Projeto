package padroescomportamentais.memento;

public class Editor {

    private String conteudo;

    public Editor() {
        this.conteudo = "";
    }

    public void digitar(String texto) {
        this.conteudo += texto;
    }

    public void limpar() {
        this.conteudo = "";
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public EditorMemento salvar() {
        return new EditorMemento(this.conteudo);
    }

    public void restaurar(EditorMemento memento) {
        this.conteudo = memento.getConteudo();
    }
}
