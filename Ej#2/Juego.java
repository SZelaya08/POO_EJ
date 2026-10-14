import java.util.ArrayList;


public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez;
    private Juego juegoPrevio1;
    private Juego juegoPrevio2;
    private Juego juegoSiguiente;
    private ArrayList<Set> sets;
    public Juego(Jugador jugador1, Jugador jugador2, Juez juez) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juez = juez;
        
        // Se crea una lista vacia para almacenar los sets del juego.
        this.sets = new ArrayList<Set>();
    }
    
    public Juego(Juego juego1, Juego juego2, Juez juez) {
        this.juegoPrevio1 = juego1;
        this.juegoPrevio2 = juego2;
        this.juez = juez;
        this.jugador1 = juego1.getGanador();
        this.jugador2 = juego2.getGanador();
        // Se crea una lista vacia para almacenar los sets del juego.
        this.sets = new ArrayList<Set>();
    }
    public Jugador getGanador(){
        int j1 = 0;
        int j2 =  0;
        for(Set x: sets){
            if(x.getPuntosJugador1()>x.getPuntosJugador2()){
                j1++;
            }else{
                j2++;
            }
        }
        if(j1>j2){
            return jugador1;
        }else{
            return jugador2;
        }
    }
    public boolean addSets(Set... set){
        int x = 0;
        for(Set set1: set){
            if(sets.contains(set1)){
            continue;
            }
            sets.add(set1);
            x++;
        }
        return x != 0;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Juez getJuez() {
        return juez;
    }

    public Juego getJuegoPrevio1() {
        return juegoPrevio1;
    }

    public Juego getJuegoPrevio2() {
        return juegoPrevio2;
    }

    public Juego getJuegoSiguiente() {
        return juegoSiguiente;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
    

    
}
