package padroescomportamentais.observer;

public interface Sujeito {
    void registrar(Observador observador);
    void remover(Observador observador);
    void notificar();
}
