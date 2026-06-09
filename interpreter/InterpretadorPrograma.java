package padroescomportamentais.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InterpretadorPrograma implements IComandoRobo {

    private final IComandoRobo comandoInicial;

    public InterpretadorPrograma(String programa) {

        List<IComandoRobo> comandos = new ArrayList<IComandoRobo>();
        List<String> tokens = Arrays.asList(programa.trim().split(" "));
        Iterator<String> iterator = tokens.iterator();

        while (iterator.hasNext()) {
            String token = iterator.next();
            if (token.equals("A")) {
                comandos.add(new Avancar());
            } else if (token.equals("G")) {
                comandos.add(new Girar());
            } else {
                throw new IllegalArgumentException("Comando inválido: " + token);
            }
        }
        comandoInicial = new Sequencia(comandos);
    }

    @Override
    public void interpretar(Robo robo) {
        comandoInicial.interpretar(robo);
    }
}
