package padroescomportamentais.mediator;

public abstract class Usuario {

    protected Mediador mediador;
    protected final String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

    public String getNome() {
        return this.nome;
    }

    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem, String remetente);
}
