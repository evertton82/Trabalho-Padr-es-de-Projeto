package padroescomportamentais.interpreter;

public class Girar implements IComandoRobo {

    @Override
    public void interpretar(Robo robo) {
        robo.girarDireita();
    }
}
