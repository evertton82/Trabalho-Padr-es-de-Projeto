package clinicaveterinaria;

public interface ObservadorAtendimento {
    void notificar(Atendimento atendimento, String evento);
}
