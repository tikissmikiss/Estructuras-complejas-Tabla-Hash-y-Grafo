package lista;


class Nodo<Tipo> {
    /*
     *************************************************************************
     * Atributos
     *************************************************************************/

    private Nodo<Tipo> anterior;
    private Nodo<Tipo> siguiente;
    private Tipo dato;

    /*
     *************************************************************************
     * Constructores
     *************************************************************************/

    public Nodo(Tipo dato) {
        this.dato = dato;
    }

    /*
     *************************************************************************
     * Getters y Setters
     *************************************************************************/

    public Tipo getDato() {
        return dato;
    }

    public Nodo<Tipo> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<Tipo> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<Tipo> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<Tipo> anterior) {
        this.anterior = anterior;
    }

    /*
     *************************************************************************
     * Metodos Override
     *************************************************************************/

    @Override
    public String toString() {
        return dato==null ? "null" : dato.toString();
    }

}

