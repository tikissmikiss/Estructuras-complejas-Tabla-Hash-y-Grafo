package lista;

import java.util.ArrayList;

public class Lista<T> {
    /*
     *************************************************************************
     * Atributos
     *************************************************************************/

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int length;

    /*
     *************************************************************************
     * Constructores
     *************************************************************************/

    public Lista() {
        this.clear();
    }

    /*
     *************************************************************************
     * Metodos publicos
     *************************************************************************/

    /**
     * Inserta un elemento nuevo al final de la lista
     * 
     * @param dato String con el dato a añadir a la lista
     * @return devuelve true si el dato se añada satisfactoriamente.
     */
    public boolean addDato(T dato) {
        // if (dato == null)
        // return false;
        Nodo<T> nuevo = new Nodo<>(dato);
        length++;
        if (cabeza == null) { // Si lista vacia
            cabeza = nuevo;
            cola = nuevo;
        } else { // Si mas de un elemento
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        return true; // TODO no seria necesario devolver. siempre inserta. pero por unificar
    }

    /**
     * Inserta un elemento en la posicion solicitada
     * 
     * @param dato     Elemento a insertar
     * @param posicion Posicion de insercion
     * @return Devuelve true si la insercion se ha realizado con exito o false si no
     *         se ha podido insertar
     */
    public boolean addDato(T dato, int posicion) {
        if (posicion == length)
            return addDato(dato);
        return addNodo(new Nodo<>(dato), buscarNodo(posicion));
    }

    /**
     * Devuelve el numero de elementos que contiene la lista
     * 
     * @return Entero con el numero de elementos que contiene la lista
     */
    public int getLenght() {
        return length;
    }

    /**
     * Borra el nodo y retornar el dato de un elemento concreto de la lista. Solo se
     * elimina la primera coincidencia.
     * 
     * @param dato Tipo con el dato que se desea sacar.
     * @return Retorna el dato del elemento encontrado o null si no lo lo encuentra
     */
    public T sacarDato(T dato) {
        Nodo<T> n = buscarNodo(new Nodo<>(dato), cabeza);
        if (n != null) {
            clearNodo(n);
            return dato; // n ya no tiene referencias
        }
        return null;
    }

    /**
     * Borrar el nodo y retornar el dato del elemento que ocupa una posición en la
     * lista.
     * 
     * @param posicion Posicion en la que se encuentra el elemnto que se desea sacar
     * @return Retorna el dato del elemento sacado o null si posicion esta fuera de
     *         rango
     */
    public T sacarDato(int posicion) {
        Nodo<T> n = buscarNodo(posicion);
        if (n != null) {
            T obj = n.getDato();
            clearNodo(n);
            return obj; // n ya no tiene referencias
        }
        return null;
    }

    /**
     * Comprueba si el dato pasado esta en la lista
     * 
     * @param dato Tipo que se desea comprobar
     * @return true si esta, false si no esta
     */
    public boolean comprobarDato(T dato) {
        return buscarNodo(new Nodo<>(dato), cabeza) != null ? true : false;
    }

    /**
     * Busca un elemento con el contenido pasado, si lo encuentra devuelve su
     * posicion, si no lo encuentra devuelve -1
     * 
     * @param dato Contenido a buscar
     * @return Posicion de la primera coincidencia. -1 si no hay coincidencia.
     */
    public int getPosicion(T dato) {
        if (cabeza == null) // lista vacia?
            return -1;
        return buscarPosicion(new Nodo<>(dato), cabeza, 0);
    }

    /**
     * Imprime y retorna el elemento que hay en una posición concreta de la lista.
     * Imprime null y retorna null si posicion esta fuera de rango
     * 
     * @param posicion Posicion del elemento solicitado
     * @return Devuelve un Tipo con el contenido del nodo solicitado. Devuelve null
     *         si la posicion esta fuera de rango
     */
    public String printPosicion(int posicion) {
        Nodo<T> n = buscarNodo(posicion);
        System.out.println(n);
        return n == null ? null : n.toString();
    }

    /**
     * Recupera el nodo de una posicion concreta.
     * 
     * @param posicion Posicion del nodo que se quiere recuperar
     * @return El Nodo de la posicion seleccionada. Si la poscion esta fuera de
     *         rango se devuelve null
     */
    public T getDato(int posicion) { // TODO añadir a memoria
        if (cabeza == null)
            return null;
        return buscarNodo(posicion).getDato();
    }

    /**
     * Imprime por consola todos los elementos que contiene la lista.
     */
    public void printLista() {
        String str = "";
        str += "    Longitud: " + length + "\n";
        str += "    Primero: " + cabeza + "\n";
        str += "    Ultimo: " + cola + "\n";

        System.out.println(str + this);
    }

    /**
     * Inicializa la lista. Si se llama y la lista tiene contenido, el contenido de
     * la lista se elimina por completo.
     */
    public void clear() {
        length = 0;
        cabeza = null;
        cola = null;
    }

    /*
     *************************************************************************
     * Metodos privados
     *************************************************************************/

    /**
     * Inserta un Nodo en la posicion de otro Nodo. Esta diseñado para inserciones
     * de nodos nuevos, no para cambiar nodos de posicion, pero esto segundo seria
     * sencillo de implementar. Tan solo seria necesario comprobar el estado de
     * {@code anterior} y {@code siguiente} del nodo nuevo y actuar en consecuencia
     * si alguno de sus valores no es null para reenlazar la lista en la posicion de
     * extraccion.
     * 
     * @param nuevo Nodo nuevo a insertar en la posicion del Nodo {@code nodo}
     * @param nodo  Nodo de la posicion de insercion. Este sera el siguiente del
     *              nuevo tras la insercion
     * @return Devuelve true si la insercion se efectua correctamente.
     */
    private boolean addNodo(Nodo<T> nuevo, Nodo<T> nodo) {
        if (nuevo == nodo)
            return false;
        if (nuevo == null || nodo == null)
            return false;
        // Desplaza el nodo actual y se inserta el nuevo delante
        nuevo.setSiguiente(nodo); // apunta siguiente del nuevo al nodo actual
        nuevo.setAnterior(nodo.getAnterior()); // apunta anterior del nuevo al nodo anterior del actual
        if (nodo.getAnterior() != null) // Hay nodo delante del actual?
            nodo.getAnterior().setSiguiente(nuevo); // pone el anterior al actual apuntando al nuevo
        else // Si anterior es null el nuevo es ahora cabeza de lista
            cabeza = nuevo;
        nodo.setAnterior(nuevo); // apunta anterior del nodo actual al nuevo
        length++;
        return true;
    }

    /**
     * Devuelve el nodo de la posicion solicita, o null en caso de estar fuera de
     * rango. Se recorre la ista en un sentido u otro dependiendo de donde este mas
     * cerca el elemnto a recuperar.
     * 
     * @param posicion Posicion de elemento que se desea recuperar
     * @return Devuelve el nodo de la poscion concreta. Devuelve null si la posicion
     *         solicitada esta fuera de rango
     */
    private Nodo<T> buscarNodo(int posicion) {
        if (posicion >= length || posicion < 0)
            return null;
        if (posicion <= length / 2)
            return buscarNodo(cabeza, Sentido.AVANCE, posicion);
        else
            return buscarNodo(cola, Sentido.RETROCESO, length - posicion - 1);
    }

    /**
     * Metodo recursivo para recorrer la lista en orden ascendente o descendente a
     * peticion. Retorna el nodo de la posicion deseada.
     * 
     * @param nodo    Nodo desde el que iniciar a recorrer.
     * @param sentido Sentido en el que recorrer la lista. AVANCE o false para
     *                recorrer de principio hacia adelante. RETROCESO o true, para
     *                recorrerla en sentido inverso.
     * @param pos     Numero de posiciones restantes para alcanzar el nodo objetivo.
     * @return Devuelve el nodo en la posicion solicitada o null si lista vacia.
     */
    private Nodo<T> buscarNodo(Nodo<T> nodo, Sentido sentido, int pos) {
        if (nodo == null)
            return null;
        if (pos != 0) {
            if (sentido == Sentido.RETROCESO)
                return buscarNodo(nodo.getAnterior(), sentido, --pos);
            else
                return buscarNodo(nodo.getSiguiente(), sentido, --pos);
        }
        return nodo;
    }

    /**
     * Busqueda recursiva de un nodo
     * 
     * @param nodoBuscado Nodo que se busca
     * @param nodoActual        Nodo a comparar
     * @return Devuelve el nodo encontrado o null si no lo encuentra
     */
    private Nodo<T> buscarNodo(Nodo<T> nodoBuscado, Nodo<T> nodoActual) {
        if (nodoActual == null || nodoBuscado == null) // algun nodo no inicializado?
            return null;
        if (nodoActual.getDato() != nodoBuscado.getDato()) // no son iguales?
            if (nodoActual.getSiguiente() != null) // no es el ultimo nodo?
                return buscarNodo(nodoBuscado, nodoActual.getSiguiente());
            else
                return null;
        return nodoActual;
    }

    /**
     * Borra el nodo y enlaza la lista adecuadamente
     * 
     * @param n Nodo que se desea borrar
     */
    private void clearNodo(Nodo<T> n) {
        length--;
        if (n != cabeza) // no es el primer nodo?
            n.getAnterior().setSiguiente(n.getSiguiente()); // enlazar anterior, con siguiente
        else
            cabeza = n.getSiguiente(); // apuntar cabeza al siguiente

        if (n != cola) // no es el ultimo nodo?
            n.getSiguiente().setAnterior(n.getAnterior()); // enlazar siguiente, con anterior
        else
            cola = n.getAnterior(); // apuntar cola al anterior
    }

    /**
     * Busqueda recursiva que compara el contenido de dos nodos recorriendo la
     * lista. Si hay coincidencia devuelve la posicion si no hay coincidencia, si no
     * hay coincidencia devuelve -1
     * 
     * @param dato     Nodo buscado
     * @param actual   Nodo a comparar
     * @param posicion Posicion actual
     * @return Si no hay coincidencia devuelve la posicion, si no hay coincidencia
     *         devuelve -1
     */
    private int buscarPosicion(Nodo<T> dato, Nodo<T> actual, int posicion) {
        if (dato.getDato() == actual.getDato()) // coincide con cabeza?
            return posicion;
        if (actual.getSiguiente() != null) // hay mas nodos?
            return buscarPosicion(dato, actual.getSiguiente(), ++posicion); // comparar siguiente
        return -1; // no encontrado
    }

    public T getCabeza() {
        return cabeza.getDato();
    }

    public T getCola() {
        return cola.getDato();
    }

    /*
     *************************************************************************
     * Getters y Setters
     *************************************************************************/

    /*
     *************************************************************************
     * Metodos Override
     *************************************************************************/

    @Override
    public String toString() { // TODO actualizar documentacion
        String str = "";
        if (cabeza == null) {
            str = "- Lista Vacia -\n";
        } else {
            Nodo<T> aux = cabeza;
            for (int i = 0; i < length; i++) {
                str += "        [ " + i + ": " + aux + " ]"; // TODO MEM no hace falta aux.toString()
                aux = aux.getSiguiente();
                if (aux != null)
                    str += "\n";
            }
        }
        return str;
    }

}
