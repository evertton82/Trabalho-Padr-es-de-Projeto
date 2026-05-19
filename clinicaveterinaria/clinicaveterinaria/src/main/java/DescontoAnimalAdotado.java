package clinicaveterinaria;

public class DescontoAnimalAdotado extends ServicoDecorator {

    private static final double PERCENTUAL = 0.10;

    public DescontoAnimalAdotado(ServicoVeterinario base) {
        super(base);
    }

    public String descricao() {
        return base.descricao() + " + desconto animal adotado";
    }

    public double valor() {
        return base.valor() * (1 - PERCENTUAL);
    }
}
