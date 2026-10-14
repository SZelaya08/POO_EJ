import java.util.ArrayList;

public class Juez extends Persona {
    private int edad;
    private ArrayList<Juego> juegos;
    public Juez(String nombre, int edad) {
        super(nombre);
        this.edad = edad;
        // Se crea una lista vacia para almacenar los juegos arbitrados.
        this.juegos = new ArrayList<Juego>();
    }
    public int getEdad() {
        return edad;
    }
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }
    
    
}
