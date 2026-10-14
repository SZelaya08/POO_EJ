import java.util.ArrayList;

public class Jugador extends Persona {
    private int sueldo;
    private ArrayList<Juego> juegos;
    public Jugador(String nombre, int sueldo) {
        super(nombre);
        this.sueldo = sueldo;
        // Se crea una lista vacia para almacenar los juegos del jugador.
        this.juegos = new ArrayList<Juego>();
        
    }
    

    
}
