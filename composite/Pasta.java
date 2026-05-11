package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.List;

public class Pasta implements ComponenteArquivo {

    private final String nome;
    private final List<ComponenteArquivo> filhos = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteArquivo componente) {
        this.filhos.add(componente);
    }

    public void remover(ComponenteArquivo componente) {
        this.filhos.remove(componente);
    }

    public List<ComponenteArquivo> getFilhos() {
        return this.filhos;
    }

    public String getNome() {
        return this.nome;
    }

    public long tamanho() {
        long total = 0;
        for (ComponenteArquivo componente : this.filhos) {
            total += componente.tamanho();
        }
        return total;
    }
}
