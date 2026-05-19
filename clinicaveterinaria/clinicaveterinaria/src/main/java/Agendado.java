package clinicaveterinaria;

public class Agendado implements SituacaoAtendimento {

    public void iniciar(Atendimento atendimento) {
        atendimento.mudarSituacao(new EmAtendimento(), Atendimento.EVENTO_INICIADO);
    }

    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento agendado precisa ser iniciado antes de finalizar");
    }

    public void cancelar(Atendimento atendimento) {
        atendimento.mudarSituacao(new Cancelado(), Atendimento.EVENTO_CANCELADO);
    }

    public String nome() {
        return "AGENDADO";
    }
}
