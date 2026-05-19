package padroescomportamentais.visitor;

public interface Visitante {
    String visitar(Leao leao);
    String visitar(Macaco macaco);
    String visitar(Elefante elefante);
}
