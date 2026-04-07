public class Configuracao {

    private static Configuracao instance = new Configuracao();

    private Configuracao() {}

    public static Configuracao getInstance() {
        return instance;
    }

    private String nomeSistema;
    private String usuarioLogado;

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}