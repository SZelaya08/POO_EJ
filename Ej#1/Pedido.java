// ArrayList almacena los productos incluidos en el pedido.
import java.util.ArrayList;

// Clase base para cualquier tipo de pedido.
// PedidoOnLine y PedidoTelefono heredan de esta clase.
public class Pedido {
    // protected permite que las clases hijas accedan a este atributo.
    protected Cliente cliente;
    // Items comprados dentro del pedido.
    protected ArrayList<Item> items;

    // ARREGLO: unico constructor base necesario para los pedidos de Main1.
    // Se copian a la lista interna para que el pedido quede completo
    // desde el momento en que se crea.
    public Pedido(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        if (items != null) {
            this.items.addAll(items);
        }
    }

    // Agrega un producto al pedido.
    // Se permiten repeticiones porque cada repeticion representa una unidad comprada.
    public boolean addItem(Item item) {
        if (item == null) {
            return false;
        }
        // Se agrega el item al final de la lista.
        items.add(item);
        return true;
    }

    // Retorna el cliente propietario del pedido.
    public Cliente getCliente() {
        return cliente;
    }

    // Cambia el cliente asociado al pedido.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Retorna los productos que contiene el pedido.
    public ArrayList<Item> getItems() {
        return items;
    }
}
