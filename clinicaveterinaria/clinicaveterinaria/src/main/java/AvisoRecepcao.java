package clinicaveterinaria;

import java.util.ArrayList;
import java.util.List;

public class AvisoRecepcao implements ObservadorAtendimento {

    private final List<String> avisosRecebidos = new ArrayList<>();

    public void notificar(Atendimento atendimento, String evento) {
        if (Atendimento.EVENTO_FINALIZADO.equals(evento)) {
            this.avisosRecebidos.add("Recepção avisada: atendimento de "
                    + atendimento.getAnimal().getNome() + " foi finalizado");
        }
    }

    public List<String> getAvisosRecebidos() {
        return this.avisosRecebidos;
    }
}
