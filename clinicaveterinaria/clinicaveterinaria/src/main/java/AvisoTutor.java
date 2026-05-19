package clinicaveterinaria;

import java.util.ArrayList;
import java.util.List;

public class AvisoTutor implements ObservadorAtendimento {

    private final List<String> avisosRecebidos = new ArrayList<>();

    public void notificar(Atendimento atendimento, String evento) {
        if (Atendimento.EVENTO_INICIADO.equals(evento)) {
            this.avisosRecebidos.add("Olá " + atendimento.getTutor().getNome()
                    + ", o atendimento de " + atendimento.getAnimal().getNome() + " foi iniciado");
        }
    }

    public List<String> getAvisosRecebidos() {
        return this.avisosRecebidos;
    }
}
