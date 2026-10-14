import java.util.*;
public class LigaTenis {
    private ArrayList<Campeonato> campeonatos;
    private ArrayList<Juez> jueces;
    private ArrayList<Jugador> jugadores;

    public LigaTenis() {
        // Se crea una lista vacia para almacenar los campeonatos.
        this.campeonatos = new ArrayList<Campeonato>();

        // Se crea una lista vacia para almacenar los jueces.
        this.jueces = new ArrayList<Juez>();

        // Se crea una lista vacia para almacenar los jugadores.
        this.jugadores = new ArrayList<Jugador>();
    }
    
    public boolean addJuez(Juez juez){
        if(jueces.contains(juez)){
            return false;
        }

        jueces.add(juez);
        return true;
    }
    public boolean addJugador(Jugador jugador){
        if(jugadores.contains(jugador)){
            return false;
        }
        jugadores.add(jugador);
        return true;
    }
    public boolean addCampeonato(Campeonato campeonato){
        if(campeonatos.contains(campeonato)){
            return false;
        }
        campeonatos.add(campeonato);
        return true;
    }

    public Campeonato getCampeonato(int posicion) {
        return campeonatos.get(posicion);
    }

    public Juez getJuez(int i) {
        return jueces.get(i);
    }

    public Jugador getJugador(int i) {
        return jugadores.get(i);
    }

    public void calcSetsGanadosJugadoresCampeonato(int i) {
        HashMap<String, Integer> setsGanados = new HashMap<>();
        
        Campeonato campeonato = campeonatos.get(i);
        for(Juego juego: campeonato.getJuegos()){
            setsGanados.put(juego.getJugador1().getNombre(), 0);
            setsGanados.put(juego.getJugador2().getNombre(), 0);
        }
        for (int j = 0; j < campeonato.getCantidadJuegos(); j++) {
            Juego juego = campeonato.getJuego(j);
            
            for (Set set : juego.getSets()) {
                String nombre;

                if (set.getPuntosJugador1() > set.getPuntosJugador2()) {
                    nombre = juego.getJugador1().getNombre();
                } else {
                    nombre = juego.getJugador2().getNombre();
                }

                setsGanados.put(
                        nombre,
                        setsGanados.getOrDefault(nombre, 0) + 1
                );
            }
        }

        for (String nombre : setsGanados.keySet()) {
            System.out.println(
                    "El jugador: " + nombre
                            + " gano " + setsGanados.get(nombre)
                            + " sets en el campeonato"
            );
        }
    }
   
}
