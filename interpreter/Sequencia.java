package padroescomportamentais.interpreter;

import java.util.List;

public class Sequencia implements IComandoRobo {

    private final List<IComandoRobo> comandos;

    public Sequencia(List<IComandoRobo> comandos) {
        this.comandos = comandos;
    }

    @Override
    public void interpretar(Robo robo) {
        for (IComandoRobo comando : comandos) {
            comando.interpretar(robo);
        }
    }
}
