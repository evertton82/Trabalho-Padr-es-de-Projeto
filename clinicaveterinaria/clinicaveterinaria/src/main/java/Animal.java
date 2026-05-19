package clinicaveterinaria;

public class Animal {

    private final String nome;
    private final String especie;
    private final boolean adotado;

    public Animal(String nome, String especie, boolean adotado) {
        this.nome = nome;
        this.especie = especie;
        this.adotado = adotado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEspecie() {
        return this.especie;
    }

    public boolean isAdotado() {
        return this.adotado;
    }
}
