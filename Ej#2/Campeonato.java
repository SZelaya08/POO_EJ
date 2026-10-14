import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Juego> juegos;

    public Campeonato() {
        // Se crea una lista vacia para almacenar los juegos del campeonato.
        juegos = new ArrayList<Juego>();
    }
    public boolean addJuego(Juego juego){
        if(juegos.contains(juego)){
            return false;
        }
        juegos.add(juego);
        return true;
    }
    
    public Juego getJuego(int i){
        return juegos.get(i);
    }

    public int getCantidadJuegos() {
        return juegos.size();
    }

    public void showResumen(){
        int j1 = 0;
        int j2 = 0;
        for(Juego x: juegos){
            System.out.println(x.getJugador1().getNombre());
            System.out.println(x.getJugador2().getNombre());
            System.out.println(x.getJuez().getNombre());
            j1 = 0;
            j2 = 0;
            int i = 1;
            for(Set y: x.getSets()){
                System.out.println("Set "+ i +": " + y.getPuntosJugador1() + " - " + y.getPuntosJugador2());
                i++;

                if (y.getPuntosJugador1() > y.getPuntosJugador2()) {
                    j1++;
                } else {
                    j2++;
                }
            }
            if(j1>j2){
                System.out.println("Ganador: " + x.getJugador1().getNombre());
            }else{
                System.out.println("Ganador: " + x.getJugador2().getNombre());
            }
        }
        if(j1>j2){
                System.out.println("Ganador del torneo: " + juegos.getLast().getJugador1().getNombre());
            }else{
                System.out.println("Ganador del torneo: " + juegos.getLast().getJugador2().getNombre());
            }
        }
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }
}
    /**
------------- Resultados -------------

Jugador 1: Rafael Nadal
Jugador 2: Martina Hingis
Juez: Pedro Perez
Set 1: 6 - 4
Set 2: 1 - 6
Set 3: 6 - 3
Ganador: Rafael Nadal
}
 */
