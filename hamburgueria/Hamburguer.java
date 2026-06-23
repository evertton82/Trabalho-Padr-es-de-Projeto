package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Hamburguer implements ItemCardapio {

    private final String nome;
    private final String pao;
    private final String carne;
    private final List<String> ingredientes;
    private final double precoBase;

    public Hamburguer(String nome, String pao, String carne, List<String> ingredientes, double precoBase) {
        this.nome = nome;
        this.pao = pao;
        this.carne = carne;
        this.ingredientes = new ArrayList<>(ingredientes);
        this.precoBase = precoBase;
    }

    @Override
    public String descricao() {
        StringBuilder sb = new StringBuilder(this.nome);
        sb.append(" (pão ").append(this.pao).append(", ").append(this.carne);
        for (String ingrediente : this.ingredientes) {
            sb.append(", ").append(ingrediente);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public double preco() {
        return this.precoBase;
    }

    public String getNome() {
        return this.nome;
    }
}
