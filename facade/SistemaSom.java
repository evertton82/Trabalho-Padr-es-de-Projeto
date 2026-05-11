package padroesestruturais.facade;

public class SistemaSom {

    private boolean ligado = false;
    private int volume = 0;

    public String ligar() {
        this.ligado = true;
        return "Som ligado";
    }

    public String desligar() {
        this.ligado = false;
        return "Som desligado";
    }

    public String ajustarVolume(int volume) {
        this.volume = volume;
        return "Volume ajustado para " + volume;
    }

    public boolean estaLigado() {
        return this.ligado;
    }

    public int getVolume() {
        return this.volume;
    }
}
