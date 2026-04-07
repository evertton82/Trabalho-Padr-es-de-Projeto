package padroescriacao.abstractfactory;

public class Cliente {

    private Mensagem mensagem;
    private Alerta alerta;

    public Cliente(FabricaNotificacao fabrica) {
        this.mensagem = fabrica.createMensagem();
        this.alerta = fabrica.createAlerta();
    }

    public String enviarMensagem() {
        return this.mensagem.enviar();
    }

    public String dispararAlerta() {
        return this.alerta.disparar();
    }
}
