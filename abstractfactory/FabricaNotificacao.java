package padroescriacao.abstractfactory;

public interface FabricaNotificacao {
    Mensagem createMensagem();
    Alerta createAlerta();
}
