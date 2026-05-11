package padroescriacao.builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String massa;
    private String molho;
    private final List<String> ingredientes = new ArrayList<>();

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    public void adicionarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public String getMassa() {
        return this.massa;
    }

    public String getMolho() {
        return this.molho;
    }

    public List<String> getIngredientes() {
        return this.ingredientes;
    }

    public String descricao() {
        return "Pizza de massa " + this.massa
                + ", molho de " + this.molho
                + ", ingredientes: " + String.join(", ", this.ingredientes);
    }
}
