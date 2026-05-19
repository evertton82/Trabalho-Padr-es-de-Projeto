package clinicaveterinaria;

import java.util.ArrayList;
import java.util.List;

public class AvisoVeterinario implements ObservadorAtendimento {

    private final List<String> avisosRecebidos = new ArrayList<>();

    public void notificar(Atendimento atendimento, String evento) {
        if (Atendimento.EVENTO_CANCELADO.equals(evento)) {
            this.avisosRecebidos.add("Veterinário avisado: atendimento de "
                    + atendimento.getAnimal().getNome() + " foi cancelado");
        }
    }

    public List<String> getAvisosRecebidos() {
        return this.avisosRecebidos;
    }
}
