package cola;

import lista.Lista;

public class Cola<Tipo> {
    private Lista<Tipo> lista;

    public Cola() {
        lista = new Lista<Tipo>();
        this.inicializar();
    }

    public boolean encolar(Tipo dato) {
        return lista.addDato(dato);
    }

    public Tipo desencolar() {
        return lista.sacarDato(0);
    }

    public Tipo getSiguiente() {
        return lista.getDato(0);
    }

    public boolean isVacia() {
        return lista.getLenght() == 0 ? true : false;
    }

    public void clear() { // TODO inicializar y limpiar redundante
        lista.clear();
    }

    public void inicializar() {
        lista.clear();
    }

    public int getLength() {
        return lista.getLenght();
    }

    public void print() {
        String str = "";
        str += "    Elementos en cola: " + getLength() + "\n";
        str += "    Ultimo:  " + lista.getDato(getLength() - 1) + "\n"; // TODO 1 menos que el numero de elementos
        str += "    Primero: " + lista.getDato(0) + "\n";
        str += "    Cola:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
