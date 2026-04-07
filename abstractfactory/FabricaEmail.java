package padroescriacao.abstractfactory;

public class FabricaEmail implements FabricaNotificacao {

    public Mensagem createMensagem() {
        return new MensagemEmail();
    }

    public Alerta createAlerta() {
        return new AlertaEmail();
    }
}
