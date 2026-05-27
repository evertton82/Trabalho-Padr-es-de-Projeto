package padroesestruturais.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaTipoArvore {

    private final Map<String, TipoArvore> pool = new HashMap<>();

    public TipoArvore obterTipo(String especie, String textura, String cor) {
        String chave = especie + "|" + textura + "|" + cor;
        TipoArvore tipo = pool.get(chave);
        if (tipo == null) {
            tipo = new TipoArvore(especie, textura, cor);
            pool.put(chave, tipo);
        }
        return tipo;
    }

    public int quantidadeTipos() {
        return pool.size();
    }
}
