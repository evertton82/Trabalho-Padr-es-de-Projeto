package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {

    private final String nome;
    private final List<ItemCardapio> itens = new ArrayList<>();

    public Combo(String nome) {
        this.nome = nome;
    }

    public Combo adicionar(ItemCardapio item) {
        this.itens.add(item);
        return this;
    }

    @Override
    public String descricao() {
        StringBuilder sb = new StringBuilder(this.nome).append(" [");
        for (int i = 0; i < this.itens.size(); i++) {
            if (i > 0) {
                sb.append(" + ");
            }
            sb.append(this.itens.get(i).descricao());
        }
        return sb.append("]").toString();
    }

    @Override
    public double preco() {
        double total = 0.0;
        for (ItemCardapio item : this.itens) {
            total += item.preco();
        }
        return total;
    }
}
