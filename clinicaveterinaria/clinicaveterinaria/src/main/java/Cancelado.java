package clinicaveterinaria;

public class Cancelado implements SituacaoAtendimento {

    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser iniciado");
    }

    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento cancelado não pode ser finalizado");
    }

    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está cancelado");
    }

    public String nome() {
        return "CANCELADO";
    }
}
