package padroescomportamentais.visitor;

public class Veterinario implements Visitante {

    public String visitar(Leao leao) {
        return "Veterinário examina os dentes do leão";
    }

    public String visitar(Macaco macaco) {
        return "Veterinário verifica a temperatura do macaco";
    }

    public String visitar(Elefante elefante) {
        return "Veterinário cuida das patas do elefante";
    }
}
