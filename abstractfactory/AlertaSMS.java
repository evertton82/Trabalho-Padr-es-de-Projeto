package padroescriacao.abstractfactory;

public class AlertaSMS implements Alerta {

    public String disparar() {
        return "Alerta disparado por SMS";
    }
}
