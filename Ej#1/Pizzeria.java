// ArrayList guarda las entidades en el mismo orden en que fueron agregadas.
import java.util.ArrayList;
// HashMap permite contar rapidamente cuantas veces aparece cada item.
import java.util.HashMap;
// Map representa la asociacion clave -> valor usada en los conteos.
import java.util.Map;

// Clase principal del sistema de la pizzeria.
public class Pizzeria {
    // Nombre comercial de la pizzeria.
    private String nombre;
    // Clientes registrados en la pizzeria.
    private ArrayList<Cliente> clientes;
    // Catalogo de productos disponibles.
    private ArrayList<Item> items;
    // Todos los pedidos recibidos.
    private ArrayList<Pedido> pedidos;

    // ARREGLO: unico constructor, porque Main1 usa new Pizzeria().
    public Pizzeria() {
        this.nombre = "";
        clientes = new ArrayList<>();
        items = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // Registra un cliente nuevo.
    // No permite clientes nulos ni repetir la misma referencia.
    public boolean addCliente(Cliente cliente) {
        if (cliente == null || clientes.contains(cliente)) {
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    // Agrega un producto al catalogo.
    // Item.equals compara por id, por eso no se aceptan ids repetidos.
    public boolean addItem(Item item) {
        if (item == null || items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    // Registra un pedido en la pizzeria y tambien en su cliente.
    public boolean addPedido(Pedido pedido) {
        // Un pedido sin cliente no puede asociarse correctamente.
        if (pedido == null || pedidos.contains(pedido) || pedido.getCliente() == null) {
            return false;
        }

        // Se guardan las dos relaciones del UML:
        // Pizzeria -> Pedido y Cliente -> Pedido.
        pedidos.add(pedido);
        addCliente(pedido.getCliente());
        pedido.getCliente().addPedido(pedido);
        return true;
    }

    // Busca un cliente por su posicion en la lista.
    // Si el indice no existe, retorna null en lugar de lanzar una excepcion.
    public Cliente getCliente(int index) {
        if (index < 0 || index >= clientes.size()) {
            return null;
        }
        return clientes.get(index);
    }

    // Busca un item por su posicion en el catalogo.
    public Item getItem(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.get(index);
    }

    // Retorna el nombre de la pizzeria.
    public String getNombre() {
        return nombre;
    }

    // Calcula la posicion del item mas comprado por un cliente.
    // Solo se cuentan los items de sus pedidos online.
    public int calcProdMasVendidoCliente(int numCliente) {
        // El parametro es el indice del cliente dentro de la lista.
        Cliente cliente = getCliente(numCliente);
        if (cliente == null) {
            // -1 representa que el cliente no existe o no tiene compras online.
            return -1;
        }

        // cantidades: id del item -> cantidad de veces comprado.
        Map<Integer, Integer> cantidades = new HashMap<>();
        // orden: id del item -> posicion en el catalogo.
        // Se usa para resolver empates.
        Map<Integer, Integer> orden = new HashMap<>();
        // Se registra la posicion de cada item del catalogo.
        for (int i = 0; i < items.size(); i++) {
            orden.put(items.get(i).getId(), i);
        }

        // Se recorren todos los pedidos del cliente.
        for (Pedido pedido : cliente.getPedidos()) {
            // Los pedidos telefonicos se ignoran.
            if (!(pedido instanceof PedidoOnLine)) {
                continue;
            }
            // Cada aparicion cuenta como una unidad comprada.
            for (Item item : pedido.getItems()) {
                int id = item.getId();
                // getOrDefault devuelve 0 cuando el item aparece por primera vez.
                cantidades.put(id, cantidades.getOrDefault(id, 0) + 1);
            }
        }

        // Valores iniciales para buscar el maximo.
        int idMasVendido = -1;
        int cantidadMayor = 0;
        int posicionGanadora = Integer.MAX_VALUE;
        // Se revisan los conteos calculados.
        for (Map.Entry<Integer, Integer> entrada : cantidades.entrySet()) {
            int id = entrada.getKey();
            int cantidad = entrada.getValue();
            int posicion = orden.getOrDefault(id, Integer.MAX_VALUE);
            // Se elige el de mayor cantidad.
            // Si hay empate, gana el que aparece primero en el catalogo.
            if (cantidad > cantidadMayor
                    || (cantidad == cantidadMayor && posicion < posicionGanadora)) {
                idMasVendido = id;
                cantidadMayor = cantidad;
                posicionGanadora = posicion;
            }
        }
        // ARREGLO: Main1 usa el resultado como indice en getItem(resultado).
        // Por eso convertimos el id ganador a la posicion que ocupa en items.
        if (idMasVendido == -1) {
            return -1;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == idMasVendido) {
                return i;
            }
        }
        return -1;
    }
}
