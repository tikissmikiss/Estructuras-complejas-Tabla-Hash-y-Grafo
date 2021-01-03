package demo;

import cola.Cola;
import demo.blackjack.Baraja;
import demo.blackjack.Carta;
import demo.blackjack.Jugador;
import demo.blackjack.UI;
import demo.util.io;
import pila.Pila;

public class DemoUsoTADs {
    private static final int NUM_JUGADORES = 6;
    private static final int NUM_RONDAS = 2;
    private static final int NUMERO_PALOS = 4;
    private static final int NUMERO_FIGURAS = 13;
    private static final int NUMERO_BARAJAS = 1;
    private static Cola<Jugador> jugCola;
    private static Pila<Carta> pilaDescartes;
    public static Jugador crupier;
    public static Baraja mazo;

    public static void main(final String[] args) {
        // El jugador pide si <= 15 (58% de pasarse aproximadamente)
        final int maxToPlay = 15;

        UI.textoCabecera();

        System.out.println("- Crear la cola de jugadores");
        jugCola = new Cola<>();
        for (int i = 1; i <= NUM_JUGADORES; i++)
            jugCola.encolar(new Jugador("Jugador_" + i));
        System.out.println("- Imprimir cola de jugadores");
        jugCola.print();
        io.esperarUsuario();

        System.out.println("\nCrear Crupier:");
        crupier = new Jugador("Crupier");
        System.out.println(crupier);
        System.out.println();
        // io.esperarUsuario();

        UI.textoCrearMazo();
        mazo = new Baraja(NUMERO_PALOS, NUMERO_FIGURAS, NUMERO_BARAJAS);
        System.out.println("Imprimir mazo:");
        System.out.println("Internamente utiliza el toString de una cola.");
        io.esperarUsuario();
        System.out.println(mazo);
        io.esperarUsuario();

        UI.textoMezclarMazo();
        mazo.mezclar();
        System.out.println("- Imprimir mazo mezclado:");
        io.esperarUsuario();
        System.out.println(mazo);
        io.esperarUsuario();

        UI.textoCrearPilaDescartes();
        pilaDescartes = new Pila<>();

        System.out.println("\n           **** Comienza la partida ****");
        for (int ronda = 1; ronda <= NUM_RONDAS; ronda++) {
            for (int i = 0; i < jugCola.getLength(); i++) {

                System.out.println("\n- Se saca un jugador de la cola para jugar la ronda");
                final Jugador jugador = jugCola.desencolar();
                io.esperarUsuario();

                UI.textoRepartirCartas();
                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.CUBIERTA));

                UI.textoComprobarBlackjackCrupier();
                if (crupier.getPuntuacion(true) == 21) {
                    UI.comprobarBJCrupier(ronda, jugador);
                } else {
                    System.out.println("No tiene Blackjack");
                    UI.trunoJugador(maxToPlay, ronda, jugador);
                    UI.turnoCrupier(ronda, jugador);
                }

                UI.mostrarGanador(jugador);

                UI.textoReencolarJugador(jugador);
                jugCola.encolar(jugador);

                UI.textoImpresionMarcador();
                jugCola.print();
                System.out.println("           >   " + crupier + " <");
                io.esperarUsuario();

                UI.textoDescartarCartas();
                while (!jugador.getMano().isVacia() || !crupier.getMano().isVacia()) {
                    if (!jugador.getMano().isVacia())
                        pilaDescartes.apilar(jugador.getMano().desapilar());
                    if (!crupier.getMano().isVacia())
                        pilaDescartes.apilar(crupier.getMano().desapilar());
                }

                UI.textoComprobarCartasEnMazo();
                System.out.println("    Quedan " + mazo.getLength() + " cartas en el mazo.");

                if (mazo.getLength() < 10) {
                    UI.textoReconstruirMazo();
                    while (!pilaDescartes.isVacia()) {
                        mazo.meterCarta(pilaDescartes.desapilar());
                    }
                    mazo.mezclar();
                }
            }
        }
    }
}
