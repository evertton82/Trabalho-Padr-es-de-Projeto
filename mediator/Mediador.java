package padroescomportamentais.mediator;

public interface Mediador {
    void registrar(Usuario usuario);
    void enviar(String mensagem, Usuario remetente);
}
