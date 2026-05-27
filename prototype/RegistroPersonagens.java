package padroescriacao.prototype;

import java.util.HashMap;
import java.util.Map;

public class RegistroPersonagens {

    private final Map<String, Personagem> modelos = new HashMap<>();

    public void cadastrar(String chave, Personagem modelo) {
        this.modelos.put(chave, modelo);
    }

    public Personagem criar(String chave) {
        Personagem modelo = this.modelos.get(chave);
        if (modelo == null) {
            return null;
        }
        return modelo.clonar();
    }
}
