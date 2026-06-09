package padroescomportamentais.interpreter;

public class Avancar implements IComandoRobo {

    @Override
    public void interpretar(Robo robo) {
        robo.avancar();
    }
}
