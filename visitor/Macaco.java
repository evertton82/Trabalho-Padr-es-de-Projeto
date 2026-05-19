package padroescomportamentais.visitor;

public class Macaco implements Animal {

    public String aceitar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
