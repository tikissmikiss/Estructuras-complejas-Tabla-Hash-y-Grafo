package demo.blackjack;

public class Carta {
    private Palo palo;
    private Figura figura;
    private VisibilidadCarta visibilidad;

    public static VisibilidadCarta VISIBLE = VisibilidadCarta.DESCUBIERTA;
    public static VisibilidadCarta CUBIERTA = VisibilidadCarta.CUBIERTA;

    public Carta(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;
        this.visibilidad = VISIBLE;
    }

    public int getValor() {
        return getValor(false);
    }

    /**
     * devuelve el valor aunque este cubierta
     * 
     * @param incluirCubiertas
     * @return
     */
    public int getValor(boolean incluirCubiertas) {
        if (visibilidad == VISIBLE || incluirCubiertas)
            return figura.getValor();
        else
            return 0;
    }

    public void setVisibilidad(VisibilidadCarta visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String stringVisible() {
        return "[" + figura + " - " + palo + "]";
    }

    @Override
    public String toString() {
        if (visibilidad == VISIBLE)
            return "[" + figura + " - " + palo + "]";
        else
        // return "[  ♠  ♣  ♥  ♦  ]"; 
        // return "[ <>  JOSE  <> ]"; 
        return "[ <> <>  <> <> ]"; 
    }
}
