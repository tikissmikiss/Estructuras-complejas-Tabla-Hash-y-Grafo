package grafo;

import java.util.Arrays;

/**
 * Matriz de Integers porque puede haber aristas de peso 0 y/o negativo
 */
class Matriz {
    private Integer[][] matriz;
    private int size;

    // Ambito de paquete
    Matriz() {
        size = 0;
        matriz = new Integer[1][1];
    }

    void set(int fila, int columna, Integer peso) {
        matriz[fila][columna] = peso;
    }

    Integer get(int fila, int columna) {
        return matriz[fila][columna];
    }

    void add() {
        if (size >= matriz.length) {
            redimensionar(size * 2);
        }
        size++;
    }

    private void redimensionar(int size) {
        int menor = this.size < size ? this.size : size;
        Integer[][] old = matriz;
        matriz = new Integer[size][size];
        for (int f = 0; f < menor; f++) {
            for (int c = 0; c < menor; c++) {
                matriz[f][c] = old[f][c];
            }
        }
    }

    void borrar(int indice) {
        size--;

        // Subir filas
        for (int f = indice; f < size; f++) {
            matriz[f] = matriz[f + 1];
        }

        // mover columnas
        for (int f = 0; f < size; f++) {
            for (int c = indice; c < size; c++) {
                matriz[f][c] = matriz[f][c + 1];
            }
        }

        // Comprobar factor de carga
        double carga = (double) matriz.length / size;
        if (carga <= (double) 1 / 3) {
            redimensionar(matriz.length / 2);
        }
    }

    void print() {
        String str = "";
        for (int fila = -1; fila < size; fila++) {
            for (int colum = -1; colum < size; colum++) {
                if (colum == -1)
                    if (fila == -1)
                        str += "\t";
                    else
                        str += fila + ":\t";
                else if (fila == -1)
                    str += colum + ":\t";
                else
                    str += matriz[fila][colum] + "\t";
            }
            str += "\n";
        }
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Matriz [matriz=" + Arrays.toString(matriz) + ", size=" + size + "]";
    }

    public int getSize() {
        return size;
    }
}