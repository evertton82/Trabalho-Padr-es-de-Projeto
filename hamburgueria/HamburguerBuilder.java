package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class HamburguerBuilder {

    private String nome = "Hambúrguer";
    private String pao = "tradicional";
    private String carne = "carne bovina";
    private final List<String> ingredientes = new ArrayList<>();
    private double precoBase = 0.0;

    public HamburguerBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public HamburguerBuilder comPao(String pao) {
        this.pao = pao;
        return this;
    }

    public HamburguerBuilder comCarne(String carne) {
        this.carne = carne;
        return this;
    }

    public HamburguerBuilder comIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
        return this;
    }

    public HamburguerBuilder comPrecoBase(double precoBase) {
        this.precoBase = precoBase;
        return this;
    }

    public Hamburguer build() {
        return new Hamburguer(this.nome, this.pao, this.carne, this.ingredientes, this.precoBase);
    }
}
