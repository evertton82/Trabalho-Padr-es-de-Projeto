package padroesestruturais.composite;

public class Arquivo implements ComponenteArquivo {

    private final String nome;
    private final long tamanho;

    public Arquivo(String nome, long tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return this.nome;
    }

    public long tamanho() {
        return this.tamanho;
    }
}
