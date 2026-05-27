package padroesestruturais.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Floresta {

    private final List<Arvore> arvores = new ArrayList<>();
    private final FabricaTipoArvore fabrica = new FabricaTipoArvore();

    public void plantar(int x, int y, String especie, String textura, String cor) {
        TipoArvore tipo = fabrica.obterTipo(especie, textura, cor);
        arvores.add(new Arvore(x, y, tipo));
    }

    public List<String> desenhar() {
        List<String> resultado = new ArrayList<>();
        for (Arvore arvore : arvores) {
            resultado.add(arvore.desenhar());
        }
        return resultado;
    }

    public int quantidadeArvores() {
        return arvores.size();
    }

    public int quantidadeTipos() {
        return fabrica.quantidadeTipos();
    }

    public List<Arvore> getArvores() {
        return arvores;
    }
}
