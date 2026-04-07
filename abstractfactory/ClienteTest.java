package padroescriacao.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveEnviarMensagemEmail() {
        FabricaNotificacao fabrica = new FabricaEmail();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Mensagem enviada por E-mail", cliente.enviarMensagem());
    }

    @Test
    void deveEnviarMensagemSMS() {
        FabricaNotificacao fabrica = new FabricaSMS();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Mensagem enviada por SMS", cliente.enviarMensagem());
    }

    @Test
    void deveDispararAlertaEmail() {
        FabricaNotificacao fabrica = new FabricaEmail();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Alerta disparado por E-mail", cliente.dispararAlerta());
    }

    @Test
    void deveDispararAlertaSMS() {
        FabricaNotificacao fabrica = new FabricaSMS();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Alerta disparado por SMS", cliente.dispararAlerta());
    }

}
