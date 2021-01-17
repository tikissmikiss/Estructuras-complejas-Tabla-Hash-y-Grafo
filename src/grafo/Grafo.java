package grafo;

import jh.lab1.lista.Lista;

public class Grafo {
    // El grafo debe cumplir los siguientes requisitos:
    // ► Debe ser posible insertar cualquier tipo de objeto, aunque debe tener una
    // clave numérica a modo de etiqueta que le represente.
    // ► La estructura de datos de soporte puede ser tanto una lista como una matriz
    // de adyacencia.
    // ► Se deben implementar las operaciones básicas vistas en el temario de clase.
    // ► Los alumnos deben asegurarse de que su código funciona correctamente
    // mediante un conjunto de pruebas suficiente, que deben estar incluidas en una
    // clase de prueba y deben mostrar los resultados convenientemente por consola,
    // para verificar el funcionamiento. Se valorará positivamente que el grafo
    // implementado se use en un PROBLEMA REAL.

    // Operaciones básicas
    // ► añadir(x) → nodo
    // ► borrar(x) → nodo y referencias
    // ► adyacente(x, y) → bool si x, y son adyacentes
    // ► vecinos(x) → nodos adyacentes a x
    // ► añadir(x, y) → añadir arista que une x e y
    // ► borrar(x, y) → borrar arista que une x e y
    // ► obtenerValorNodo(x) → objeto encapsulado en el vértice
    // ► establecerValorNodo(x, a) → asignar a como valor de x

    // Operaciones básicas sobre grafos ponderados
    // ► obtenerValorArco(x, y)
    // ► establecerValorArco(x, y, a)

    // ************************************************************************
    // * /Constantes\
    // ************************************************************************

    // ************************************************************************
    // * /Atributos\
    // ************************************************************************
    // private Lista<Lista<Integer>> matrizAdyacencia; // La posicion 0 de la lista
    // de vertices es el nodo referido
    private Matriz mAdyacencia;
    private boolean dirigido;
    private int numNodos;
    private Lista<Nodo> nodos;

    // ************************************************************************
    // * /Constructores\
    // ************************************************************************
    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
        mAdyacencia = new Matriz();
        nodos = new Lista<>();
    }

    // ************************************************************************
    // * /Métodos internos\
    // ************************************************************************

    // ************************************************************************
    // * /Métodos Públicos\
    // ************************************************************************
    // Operaciones básicas
    /**
     * Añade un elemento al grafo
     * 
     * @param x Object con el elemento a añadir
     * @return devuelve una referencia al nuevo Vertice
     */
    public Nodo addNodo(Object x) throws Exception { // → nodo
        Nodo nodo = new Nodo(numNodos, x);

        // Comprobar si no existe ya el nodo
        Nodo aux = nodos.getDato(nodo);
        if (aux == null) {// Si no existe se añade
            nodos.addDato(nodo);
            mAdyacencia.add();
            numNodos = nodos.getLenght();
        } else {
            throw new Exception("El objeto que se quiere introducir ya existe");
        }
        
        return nodo;
    }

    // public boolean borrar(Object x) { // → nodo y referencias
    //     Nodo nodo = new Nodo(numNodos, x);
    //     return borrar(nodo);
    // }

    public boolean borrar(Nodo x) { // → nodo y referencias
        boolean ret = false;

        // Sacar nodo si existe. Lo borra
        x = nodos.sacarDato(x);
        if (x != null) {
            // Borrar adyacencias
            mAdyacencia.borrar(x.getClave());
            ret = true;
        }
        return ret;
    }

    // public boolean adyacente(Object x, Object y) { // → bool si x, y son adyacentes
    //     return obtenerValorArco(x, y) != null;
    // }

    public boolean adyacente(Nodo x, Nodo y) { // → bool si x, y son adyacentes
        return obtenerValorArco(x, y) != null;
    }

    // public Object[] vecinos(Object x) { // → nodos adyacentes a x
    //     Nodo nodo = new Nodo(numNodos, x); // No importa la clave. El .equals() solo compara el valor
    //     nodo = nodos.getDato(nodo);
    //     return vecinos(nodo);
    // }

    public Nodo[] vecinos(Nodo x) { // → nodos adyacentes a x
        Lista<Nodo> aux = new Lista<>();
        int fila = x.getClave();

        for (int i = 0; i < mAdyacencia.getSize(); i++)
            // if (adyacencia.matriz[fila][i] != null)
            if (mAdyacencia.get(fila, i) != null)
                aux.addDato(nodos.getDato(i));

        // Extraer los valores a un array
        Nodo[] ret = new Nodo[aux.getLenght()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = aux.sacarDato(0);

        return ret;
    }

    /**
     * Si el grafo es dirigido añade una arista de 'x' a 'y'. Si no es dirigido
     * añade ademas una arista de 'y' a 'x'.
     * 
     * @param x Vertice
     * @param y Vertice
     */
    public void addArista(Nodo x, Nodo y) { // → añadir arista que une x e y
        addAdyacencia(x, y, 1);
        if (!dirigido) {
            addAdyacencia(y, x, 1);
        }
    }

    /**
     * Si el grafo es dirigido añade una arista de 'x' a 'y'. Si no es dirigido
     * añade ademas una arista de 'y' a 'x'.
     * 
     * @param x
     * @param y
     * @param peso
     */
    public void addArista(Nodo x, Nodo y, int peso) {
        addAdyacencia(x, y, peso);
        if (!dirigido) {
            addAdyacencia(y, x, peso);
        }
    }

    private void addAdyacencia(Nodo desde, Nodo hasta, int peso) {
        int fila = desde.getClave();
        int columna = hasta.getClave();
        mAdyacencia.set(fila, columna, peso);
    }

    public boolean borrarArista(Nodo x, Nodo y) { // → borrar arista que une x e y
        boolean ret = false;
        if (x != null && y != null) {
            mAdyacencia.set(x.getClave(), y.getClave(), null);
            if (!dirigido)
                mAdyacencia.set(y.getClave(), x.getClave(), null);
            ret = true;
        }
        return ret;
    }

    public Object obtenerValorNodo(Nodo x) { // → objeto encapsulado en el vértice
        return x.getValor();
    }

    // public void establecerValorNodo(Object x, Object a) {
    //     Nodo vX = new Nodo(numNodos, x); // No importa la clave. El .equals() solo compara el valor
    //     vX = nodos.getDato(vX);
	// }

    public void establecerValorNodo(Nodo x, Object a) { // → asignar a como valor de x
        x.setValor(a);
    }

    // Operaciones básicas sobre grafos ponderados
    // public Integer obtenerValorArco(Object x, Object y) { // No se pide pero parece oportuno
    //     Nodo vX = new Nodo(numNodos, x); // No importa la clave. El .equals() solo compara el valor
    //     Nodo vY = new Nodo(numNodos, y); // No importa la clave. El .equals() solo compara el valor
    //     vX = nodos.getDato(vX);
    //     vY = nodos.getDato(vY);
    //     return obtenerValorArco(vX, vY);
    // }

    public Integer obtenerValorArco(Nodo x, Nodo y) { // No se pide pero parece oportuno
        Integer peso = null;
        if (x != null && y != null)
            peso = mAdyacencia.get(x.getClave(), y.getClave());

        return peso;
    }

    // public boolean establecerValorArco(Object x, Object y, int a) {
    //     Nodo vX = new Nodo(numNodos, x); // No importa la clave. El .equals() solo compara el valor
    //     Nodo vY = new Nodo(numNodos, y); // No importa la clave. El .equals() solo compara el valor
    //     vX = nodos.getDato(vX);
    //     vY = nodos.getDato(vY);
    //     return establecerValorArco(vX, vY, a);
    // }

    public boolean establecerValorArco(Nodo x, Nodo y, int a) {
        boolean ret = false;
        if (x != null && y != null) {
            mAdyacencia.set(x.getClave(), y.getClave(), a);
            if (!dirigido)
                mAdyacencia.set(y.getClave(), x.getClave(), a);
            ret = true;
        }
        return ret;
    }

    public void printMatrizAdyacencia() {
        System.out.println("Matriz de adyacencia:");
        mAdyacencia.print();
    }

    public boolean esDirigido() {
        return dirigido;
    }


    // ************************************************************************
    // * /Setters & Getters\
    // ************************************************************************

    // ************************************************************************
    // * /Métodos override\
    // ************************************************************************

}
