package padroescomportamentais.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class Historico {

    private final Deque<EditorMemento> pilha;

    public Historico() {
        this.pilha = new ArrayDeque<>();
    }

    public void empilhar(EditorMemento memento) {
        this.pilha.push(memento);
    }

    public EditorMemento desempilhar() {
        if (this.pilha.isEmpty()) {
            return null;
        }
        return this.pilha.pop();
    }

    public boolean vazio() {
        return this.pilha.isEmpty();
    }

    public int tamanho() {
        return this.pilha.size();
    }
}
