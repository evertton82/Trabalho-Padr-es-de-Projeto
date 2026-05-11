package padroesestruturais.facade;

public class HomeTheaterFacade {

    private final Projetor projetor;
    private final SistemaSom som;
    private final Luzes luzes;

    public HomeTheaterFacade(Projetor projetor, SistemaSom som, Luzes luzes) {
        this.projetor = projetor;
        this.som = som;
        this.luzes = luzes;
    }

    public String iniciarFilme() {
        StringBuilder log = new StringBuilder();
        log.append(this.luzes.diminuir(20)).append(" | ");
        log.append(this.projetor.ligar()).append(" | ");
        log.append(this.som.ligar()).append(" | ");
        log.append(this.som.ajustarVolume(7));
        return log.toString();
    }

    public String encerrarFilme() {
        StringBuilder log = new StringBuilder();
        log.append(this.som.desligar()).append(" | ");
        log.append(this.projetor.desligar()).append(" | ");
        log.append(this.luzes.acender());
        return log.toString();
    }
}
