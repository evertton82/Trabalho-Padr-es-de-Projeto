package padroesestruturais.facade;

public class Projetor {

    private boolean ligado = false;

    public String ligar() {
        this.ligado = true;
        return "Projetor ligado";
    }

    public String desligar() {
        this.ligado = false;
        return "Projetor desligado";
    }

    public boolean estaLigado() {
        return this.ligado;
    }
}
