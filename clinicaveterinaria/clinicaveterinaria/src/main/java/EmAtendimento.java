package clinicaveterinaria;

public class EmAtendimento implements SituacaoAtendimento {

    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento já está em andamento");
    }

    public void finalizar(Atendimento atendimento) {
        atendimento.mudarSituacao(new Finalizado(), Atendimento.EVENTO_FINALIZADO);
    }

    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Atendimento em andamento não pode ser cancelado");
    }

    public String nome() {
        return "EM_ATENDIMENTO";
    }
}
