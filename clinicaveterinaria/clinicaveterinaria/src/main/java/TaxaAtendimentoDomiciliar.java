package clinicaveterinaria;

public class TaxaAtendimentoDomiciliar extends ServicoDecorator {

    private static final double TAXA = 50.00;

    public TaxaAtendimentoDomiciliar(ServicoVeterinario base) {
        super(base);
    }

    public String descricao() {
        return base.descricao() + " + taxa domiciliar";
    }

    public double valor() {
        return base.valor() + TAXA;
    }
}
