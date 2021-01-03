package pila;

import lista.Lista;

public class Pila<Tipo> {
    private Lista<Tipo> lista;

    public Pila() {
        lista = new Lista<Tipo>();
        this.inicializar();
    }

    public boolean apilar(Tipo dato) {
        return lista.addDato(dato);
    }

    public Tipo desapilar() {
        return lista.sacarDato(lista.getLenght() - 1);
    }

    public Tipo getCima() {
        return lista.getDato(lista.getLenght() - 1);
    }

    public int getLength() {
        return lista.getLenght();
    }

    public boolean isVacia() {
        return lista.getLenght() == 0 ? true : false;
    }

    public void clear() { // TODO es redundante
        lista.clear();
    }

    public void inicializar() {
        lista.clear();
    }

    public void print() {
        String str = "";
        str += "    n:" + getLength() + "\n";
        str += "    cima:" + getCima() + "\n";
        str += "    lista:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
