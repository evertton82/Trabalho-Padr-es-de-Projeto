package clinicaveterinaria;

public class Finalizado implements SituacaoAtendimento {

    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser iniciado");
    }

    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está finalizado");
    }

    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento finalizado não pode ser cancelado");
    }

    public String nome() {
        return "FINALIZADO";
    }
}
