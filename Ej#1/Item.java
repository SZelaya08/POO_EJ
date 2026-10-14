// Representa un producto que la pizzeria puede vender.
public class Item {
    // ARREGLO: permite que Main1 cree items sin enviar un id.
    // El id se genera automaticamente y no depende del usuario.
    private static int siguienteId = 0;

    // Identificador unico del producto.
    private int id;
    // Nombre que se muestra para el producto.
    private String nombre;
    // Precio o valor del producto.
    private int valor;

    // ARREGLO: unico constructor, porque Main1 crea items con solo nombre y valor.
    // El id se genera automaticamente para identificar cada producto.
    public Item(String nombre, int valor) {
        this.id = siguienteId++;
        this.nombre = nombre;
        this.valor = valor;
    }

    // Getter del identificador.
    public int getId() {
        return id;
    }

    // Getter del nombre.
    public String getNombre() {
        return nombre;
    }

    // Getter del valor.
    public int getValor() {
        return valor;
    }

    // Dos items se consideran iguales si tienen el mismo id.
    @Override
    public boolean equals(Object obj) {
        // Si el objeto no es un Item, no pueden ser iguales.
        if (!(obj instanceof Item)) {
            return false;
        }
        // Se hace casting para acceder al id del otro Item.
        return id == ((Item) obj).id;
    }

    // Debe coincidir con equals para que Item funcione correctamente
    // en colecciones como HashMap y HashSet.
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
