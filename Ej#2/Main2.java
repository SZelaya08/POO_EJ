public class Main2 {
    
    public static void main(String[] args) {
        // Creacion de la liga
        LigaTenis liga = new LigaTenis();

        // Creacion de los jueces
        liga.addJuez(new Juez("Pedro Perez", 35));
        liga.addJuez(new Juez("Alejandro Fernandez", 29));
        liga.addJuez(new Juez("Mercedez", 54));

        // Creacion de los jugadores
        liga.addJugador(new Jugador("Rafael Nadal", 1250));
        liga.addJugador(new Jugador("Martina Hingis", 980));
        liga.addJugador(new Jugador("Roger Federer", 1420));
        liga.addJugador(new Jugador("Monica Seles", 1120));
        liga.addJugador(new Jugador("Novak Djokovic", 1030));
        liga.addJugador(new Jugador("Venus Williams", 1390));
        liga.addJugador(new Jugador("Andre Agassi", 940));
        liga.addJugador(new Jugador("Martina Navratilova", 1080));

        // Creacion del campeonato
        liga.addCampeonato(new Campeonato());

        // Todos los juegos de la primera ronda se crean en este punto.
        for (int i = 0; i < 8; i += 2) {
            liga.getCampeonato(0).addJuego(new Juego(liga.getJugador(i), liga.getJugador(i + 1), liga.getJuez((i / 2) % 2)));
        }

        liga.getCampeonato(0).getJuego(0).addSets(new Set(6, 4), new Set(1, 6), new Set(6, 3));
        liga.getCampeonato(0).getJuego(1).addSets(new Set(6, 1), new Set(5, 7), new Set(3, 6));
        liga.getCampeonato(0).getJuego(2).addSets(new Set(1, 6), new Set(4, 6));
        liga.getCampeonato(0).getJuego(3).addSets(new Set(6, 2), new Set(6, 0));

        // Semifinal
        for (int i = 0; i < 4; i += 2) {
            liga.getCampeonato(0).addJuego(new Juego(liga.getCampeonato(0).getJuego(i), liga.getCampeonato(0).getJuego(i + 1), liga.getJuez((i / 2) % 2)));
        }

        liga.getCampeonato(0).getJuego(4).addSets(new Set(6, 4), new Set(4, 6), new Set(3, 6));
        liga.getCampeonato(0).getJuego(5).addSets(new Set(7, 5), new Set(2, 6), new Set(1, 6));

        // Final
        liga.getCampeonato(0).addJuego(new Juego(liga.getCampeonato(0).getJuego(4), liga.getCampeonato(0).getJuego(5), liga.getJuez(0)));
        liga.getCampeonato(0).getJuego(6).addSets(new Set(6, 2), new Set(3, 6), new Set(7, 9));

        // Ejecucion de metodos
        liga.getCampeonato(0).showResumen();
        liga.calcSetsGanadosJugadoresCampeonato(0);
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

Jugador 1: Roger Federer
Jugador 2: Monica Seles
Juez: Alejandro Fernandez
Set 1: 6 - 1
Set 2: 5 - 7
Set 3: 3 - 6
Ganador: Monica Seles

Jugador 1: Novak Djokovic
Jugador 2: Venus Williams
Juez: Pedro Perez
Set 1: 1 - 6
Set 2: 4 - 6
Ganador: Venus Williams

Jugador 1: Andre Agassi
Jugador 2: Martina Navratilova
Juez: Alejandro Fernandez
Set 1: 6 - 2
Set 2: 6 - 0
Ganador: Andre Agassi

Jugador 1: Rafael Nadal
Jugador 2: Monica Seles
Juez: Pedro Perez
Set 1: 6 - 4
Set 2: 4 - 6
Set 3: 3 - 6
Ganador: Monica Seles

Jugador 1: Venus Williams
Jugador 2: Andre Agassi
Juez: Alejandro Fernandez
Set 1: 7 - 5
Set 2: 2 - 6
Set 3: 1 - 6
Ganador: Andre Agassi

Jugador 1: Monica Seles
Jugador 2: Andre Agassi
Juez: Pedro Perez
Set 1: 6 - 2
Set 2: 3 - 6
Set 3: 7 - 9
Ganador: Andre Agassi

El ganador del campeonato es: Andre Agassi

El jugador: Rafael Nadal gano 3 sets en el campeonato
El jugador: Martina Hingis gano 1 sets en el campeonato
El jugador: Roger Federer gano 1 sets en el campeonato
El jugador: Monica Seles gano 5 sets en el campeonato
El jugador: Novak Djokovic gano 0 sets en el campeonato
El jugador: Venus Williams gano 3 sets en el campeonato
El jugador: Andre Agassi gano 6 sets en el campeonato
El jugador: Martina Navratilova gano 0 sets en el campeonato
*/
