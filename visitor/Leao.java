package padroescomportamentais.visitor;

public class Leao implements Animal {

    public String aceitar(Visitante visitante) {
        return visitante.visitar(this);
    }
}
