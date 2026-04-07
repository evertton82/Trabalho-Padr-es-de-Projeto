package padroescriacao.abstractfactory;

public class AlertaEmail implements Alerta {

    public String disparar() {
        return "Alerta disparado por E-mail";
    }
}
