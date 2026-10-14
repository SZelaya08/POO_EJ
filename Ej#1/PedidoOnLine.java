import java.util.ArrayList;

// Pedido realizado por internet.
// Hereda cliente e items de Pedido.
public class PedidoOnLine extends Pedido {
    // Correo usado para realizar el pedido online.
    private String email;

    // ARREGLO: unico constructor online, exactamente como lo usa Main1.
    public PedidoOnLine(Cliente cliente, String email, ArrayList<Item> items) {
        super(cliente, items);
        this.email = email;
    }

    // Retorna el correo del pedido.
    public String getEmail() {
        return email;
    }
}
