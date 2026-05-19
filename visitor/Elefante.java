package padroescomportamentais.visitor;

public class Elefante implements Animal {

    public String aceitar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
