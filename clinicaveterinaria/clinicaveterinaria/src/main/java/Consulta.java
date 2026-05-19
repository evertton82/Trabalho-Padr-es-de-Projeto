package clinicaveterinaria;

public class Consulta implements ServicoVeterinario {

    private final double valorBase;

    public Consulta(double valorBase) {
        this.valorBase = valorBase;
    }

    public String descricao() {
        return "Consulta";
    }

    public double valor() {
        return this.valorBase;
    }
}
