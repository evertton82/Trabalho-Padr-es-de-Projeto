package clinicaveterinaria;

public abstract class ServicoDecorator implements ServicoVeterinario {

    protected final ServicoVeterinario base;

    protected ServicoDecorator(ServicoVeterinario base) {
        this.base = base;
    }
}
