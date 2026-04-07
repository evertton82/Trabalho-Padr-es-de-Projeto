package padroescriacao.abstractfactory;

public class MensagemEmail implements Mensagem {

    public String enviar() {
        return "Mensagem enviada por E-mail";
    }
}
