package padroescriacao.abstractfactory;

public class FabricaSMS implements FabricaNotificacao {

    public Mensagem createMensagem() {
        return new MensagemSMS();
    }

    public Alerta createAlerta() {
        return new AlertaSMS();
    }
}
