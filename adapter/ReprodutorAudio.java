package padroesestruturais.adapter;

public class ReprodutorAudio implements ILeitorMidia {

    private final ILeitorMidia adaptador;

    public ReprodutorAudio() {
        this.adaptador = new AdaptadorMidia();
    }

    @Override
    public String tocar(String tipo, String nomeArquivo) {
        if (tipo.equals("mp3")) {
            return "Tocando MP3: " + nomeArquivo;
        }
        return adaptador.tocar(tipo, nomeArquivo);
    }
}
