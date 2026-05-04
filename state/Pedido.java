package padroescomportamentais.state;

public class Pedido {

    private EstadoPedido estado;

    public Pedido() {
        this.estado = new PedidoNovo();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String estadoAtual() {
        return this.estado.nome();
    }

    public void pagar() {
        this.estado.pagar(this);
    }

    public void enviar() {
        this.estado.enviar(this);
    }

    public void entregar() {
        this.estado.entregar(this);
    }
}
