package clinicaveterinaria;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {

    public static final String EVENTO_INICIADO = "INICIADO";
    public static final String EVENTO_FINALIZADO = "FINALIZADO";
    public static final String EVENTO_CANCELADO = "CANCELADO";

    private final Tutor tutor;
    private final Animal animal;
    private final ServicoVeterinario servico;
    private SituacaoAtendimento situacao;
    private final List<ObservadorAtendimento> observadores = new ArrayList<>();

    public Atendimento(Tutor tutor, Animal animal, ServicoVeterinario servico) {
        this.tutor = tutor;
        this.animal = animal;
        this.servico = servico;
        this.situacao = new Agendado();
    }

    public void adicionarObservador(ObservadorAtendimento observador) {
        this.observadores.add(observador);
    }

    public void removerObservador(ObservadorAtendimento observador) {
        this.observadores.remove(observador);
    }

    public void iniciar() {
        this.situacao.iniciar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public void cancelar() {
        this.situacao.cancelar(this);
    }

    public void mudarSituacao(SituacaoAtendimento novaSituacao, String evento) {
        this.situacao = novaSituacao;
        notificarTodos(evento);
    }

    public void notificarTodos(String evento) {
        for (ObservadorAtendimento o : this.observadores) {
            o.notificar(this, evento);
        }
    }

    public String situacaoAtual() {
        return this.situacao.nome();
    }

    public Tutor getTutor() {
        return this.tutor;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public double valorFinal() {
        return this.servico.valor();
    }

    public String descricaoServico() {
        return this.servico.descricao();
    }
}
