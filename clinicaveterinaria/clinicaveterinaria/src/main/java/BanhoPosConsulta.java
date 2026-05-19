package clinicaveterinaria;

public class BanhoPosConsulta extends ServicoDecorator {

    private static final double PRECO = 30.00;

    public BanhoPosConsulta(ServicoVeterinario base) {
        super(base);
    }

    public String descricao() {
        return base.descricao() + " + banho pós-consulta";
    }

    public double valor() {
        return base.valor() + PRECO;
    }
}
