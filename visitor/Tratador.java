package padroescomportamentais.visitor;

public class Tratador implements Visitante {

    public String visitar(Leao leao) {
        return "Tratador alimenta o leão com 5kg de carne";
    }

    public String visitar(Macaco macaco) {
        return "Tratador alimenta o macaco com bananas";
    }

    public String visitar(Elefante elefante) {
        return "Tratador alimenta o elefante com feno";
    }
}
