// ArrayList permite guardar una cantidad variable de pedidos.
import java.util.ArrayList;

// Representa a una persona que realiza pedidos en la pizzeria.
public class Cliente {
    // Nombre del cliente.
    private String nombre;
    // Pedidos realizados por este cliente.
    private ArrayList<Pedido> pedidos;

    // Constructor del cliente.
    public Cliente(String nombre) {
        this.nombre = nombre;
        pedidos = new ArrayList<>();
    }

    // Agrega un pedido a la lista del cliente.
    // Retorna false si el pedido es nulo o ya estaba registrado.
    public boolean addPedido(Pedido pedido) {
        if (pedido == null || pedidos.contains(pedido)) {
            return false;
        }

        // Se guarda la relacion Cliente -> Pedido.
        pedidos.add(pedido);
        // Se asegura tambien la relacion Pedido -> Cliente.
        if (pedido.getCliente() != this) {
            pedido.setCliente(this);
        }
        return true;
    }

    // Retorna el nombre del cliente.
    public String getNombre() {
        return nombre;
    }

    // Retorna todos los pedidos del cliente.
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
