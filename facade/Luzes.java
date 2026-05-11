package padroesestruturais.facade;

public class Luzes {

    private int intensidade = 100;

    public String diminuir(int percentual) {
        this.intensidade = percentual;
        return "Luzes em " + percentual + "%";
    }

    public String acender() {
        this.intensidade = 100;
        return "Luzes acesas em 100%";
    }

    public int getIntensidade() {
        return this.intensidade;
    }
}
