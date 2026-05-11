package padroescomportamentais.mediator;

import java.util.ArrayList;
import java.util.List;

public class SalaChat implements Mediador {

    private final List<Usuario> usuarios = new ArrayList<>();

    public void registrar(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.setMediador(this);
    }

    public void enviar(String mensagem, Usuario remetente) {
        for (Usuario usuario : this.usuarios) {
            if (usuario != remetente) {
                usuario.receber(mensagem, remetente.getNome());
            }
        }
    }
}
