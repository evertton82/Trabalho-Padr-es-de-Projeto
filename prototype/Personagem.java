package padroescriacao.prototype;

public abstract class Personagem {

    protected String nome;
    protected int vida;
    protected int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract Personagem clonar();

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
    }
}
