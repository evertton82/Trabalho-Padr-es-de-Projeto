package padroescomportamentais.interpreter;

public class Robo {

    private int x;
    private int y;
    private char direcao;

    public Robo() {
        this.x = 0;
        this.y = 0;
        this.direcao = 'N';
    }

    public void avancar() {
        switch (direcao) {
            case 'N': y++; break;
            case 'L': x++; break;
            case 'S': y--; break;
            case 'O': x--; break;
        }
    }

    public void girarDireita() {
        switch (direcao) {
            case 'N': direcao = 'L'; break;
            case 'L': direcao = 'S'; break;
            case 'S': direcao = 'O'; break;
            case 'O': direcao = 'N'; break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirecao() {
        return direcao;
    }

    public String posicao() {
        return "(" + x + ", " + y + ") " + direcao;
    }
}
