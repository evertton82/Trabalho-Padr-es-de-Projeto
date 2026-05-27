package padroescriacao.prototype;

public class Guerreiro extends Personagem {

    private String armaPrincipal;

    public Guerreiro(String nome, int vida, int ataque, String armaPrincipal) {
        super(nome, vida, ataque);
        this.armaPrincipal = armaPrincipal;
    }

    public Personagem clonar() {
        return new Guerreiro(this.nome, this.vida, this.ataque, this.armaPrincipal);
    }

    public String getArmaPrincipal() {
        return armaPrincipal;
    }
}
