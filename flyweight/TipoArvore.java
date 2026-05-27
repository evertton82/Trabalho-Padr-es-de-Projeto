package padroesestruturais.flyweight;

public class TipoArvore {

    private final String especie;
    private final String textura;
    private final String cor;

    public TipoArvore(String especie, String textura, String cor) {
        this.especie = especie;
        this.textura = textura;
        this.cor = cor;
    }

    public String desenhar(int x, int y) {
        return especie + "(" + cor + ") em (" + x + "," + y + ")";
    }

    public String getEspecie() {
        return especie;
    }

    public String getTextura() {
        return textura;
    }

    public String getCor() {
        return cor;
    }
}
