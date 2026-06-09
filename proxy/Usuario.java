package padroesestruturais.proxy;

public class Usuario {

    private String nome;
    private boolean autorizado;

    public Usuario(String nome, boolean autorizado) {
        this.nome = nome;
        this.autorizado = autorizado;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAutorizado() {
        return autorizado;
    }
}
