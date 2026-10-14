import java.util.ArrayList;

// Pedido realizado mediante una llamada telefonica.
// Hereda cliente e items de Pedido.
public class PedidoTelefono extends Pedido {
    // Numero de telefono usado para realizar el pedido.
    private String telefono;

    // ARREGLO: unico constructor telefonico, exactamente como lo usa Main1.
    public PedidoTelefono(Cliente cliente, String telefono, ArrayList<Item> items) {
        super(cliente, items);
        this.telefono = telefono;
    }

    // Retorna el numero de telefono del pedido.
    public String getTelefono() {
        return telefono;
    }
}
