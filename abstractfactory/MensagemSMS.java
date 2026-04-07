package padroescriacao.abstractfactory;

public class MensagemSMS implements Mensagem {

    public String enviar() {
        return "Mensagem enviada por SMS";
    }
}
