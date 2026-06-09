package padroesestruturais.adapter;

public class AdaptadorMidia implements ILeitorMidia {

    private final ReprodutorAvancado reprodutorAvancado;

    public AdaptadorMidia() {
        this.reprodutorAvancado = new ReprodutorAvancado();
    }

    @Override
    public String tocar(String tipo, String nomeArquivo) {
        switch (tipo) {
            case "mp4":
                return reprodutorAvancado.tocarMp4(nomeArquivo);
            case "vlc":
                return reprodutorAvancado.tocarVlc(nomeArquivo);
            default:
                throw new IllegalArgumentException("Formato não suportado: " + tipo);
        }
    }
}
