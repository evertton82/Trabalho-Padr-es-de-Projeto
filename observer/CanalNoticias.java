package padroescomportamentais.observer;

import java.util.ArrayList;
import java.util.List;

public class CanalNoticias implements Sujeito {

    private final List<Observador> observadores = new ArrayList<>();
    private String ultimaNoticia;

    public void registrar(Observador observador) {
        this.observadores.add(observador);
    }

    public void remover(Observador observador) {
        this.observadores.remove(observador);
    }

    public void notificar() {
        for (Observador observador : this.observadores) {
            observador.atualizar(this.ultimaNoticia);
        }
    }

    public void publicar(String noticia) {
        this.ultimaNoticia = noticia;
        notificar();
    }
}
