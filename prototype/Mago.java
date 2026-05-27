package padroescriacao.prototype;

public class Mago extends Personagem {

    private String magiaPrincipal;

    public Mago(String nome, int vida, int ataque, String magiaPrincipal) {
        super(nome, vida, ataque);
        this.magiaPrincipal = magiaPrincipal;
    }

    public Personagem clonar() {
        return new Mago(this.nome, this.vida, this.ataque, this.magiaPrincipal);
    }

    public String getMagiaPrincipal() {
        return magiaPrincipal;
    }
}
