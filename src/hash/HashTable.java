package hash;

import java.util.Arrays;
import java.util.Objects;

import jh.lab1.lista.*;
import jh.util.io;

public class HashTable {
    // codigo actual lo acepta.

    // ************************************************************************
    // * /Constantes\
    // ************************************************************************
    private static final double FACTOR_CARGA_AUMENTAR = 1; // Valor para redispersión (aumentar)
    private static final double FACTOR_CARGA_REDUCIR = (double) 1 / 3; // Valor para redispersión inversa (reducir)
    private static final int PRIMO_INICIAL = 3;

    // ************************************************************************
    // * /Atributos\
    // ************************************************************************
    private int[] primos;
    private int iPrimo;
    // Lista de listas de parejas clave:valor
    // He elegido un vector en vez de mi lista enlazada por que permite acceso
    // aleatorio
    private Lista<ClaveValor>[] vectorPrincipal;
    private int size;
    private double factorCarga;

    // ************************************************************************
    // * /Constructores\
    // ************************************************************************
    public HashTable() {
        inicializar();
    }

    // ************************************************************************
    // * /Métodos internos\
    // ************************************************************************
    /**
     * Calcula la posición de inserción
     * 
     * @param clave String con la clave del par clave:valor
     * @return entero con la posición de inserción
     */
    private int funcionHash(String clave) {
        int hashCode = 0;
        char[] chClave = clave.toCharArray();
        for (int i = 0; i < chClave.length; i++) {
            hashCode += chClave[i] * (i + 1);
        }
        return hashCode % vectorPrincipal.length;
    }

    @SuppressWarnings("unchecked")
    private void inicializar() {
        if (primos == null)
            primosPorDefecto();

        iPrimo = getIndicePrimo(PRIMO_INICIAL);

        // Dimensiona el vector al tamaño del primo en la posición de iPrimo
        vectorPrincipal = new Lista[primos[iPrimo]];

        // Crea una lista en cada posición del array
        for (int i = 0; i < vectorPrincipal.length; i++) {
            vectorPrincipal[i] = new Lista<ClaveValor>();
        }
    }

    private int getIndicePrimo(int numero) {
        int i = iPrimo;
        int primo = primos[i];
        if (primo < numero) {
            while (primo < numero) {
                primo = primos[++i];
            }
        } else {
            while (primo > numero) {
                primo = primos[--i];
            }
        }
        return i;
    }

    // ************************************************************************
    // * /Métodos Públicos\
    // ************************************************************************

    public boolean buscar(String clave) {
        return vectorPrincipal[funcionHash(clave)].getDato(new ClaveValor(clave, null)) != null;
    }

    public boolean insertar(String clave, Object valor) {
        size++;
        ClaveValor item = new ClaveValor(clave, valor);
        boolean res = false;
        if (Objects.isNull(get(clave))) {
            vectorPrincipal[funcionHash(clave)].addDato(item);

            // Comprueba, redispersan si es necesario y actualiza el parámetro
            factorCarga = (double) size / vectorPrincipal.length;

            if (factorCarga > FACTOR_CARGA_AUMENTAR)
                redispersion(vectorPrincipal.length * 2);

            res = true;
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    private void redispersion(int newSize) { // redispersion y redispersion inversa según necesidad
        iPrimo = getIndicePrimo(newSize);

        // Guardamos referencia al vector actual
        Lista<ClaveValor>[] oldVector = vectorPrincipal;

        // Redimensionamos el vector al tamaño del primo en la posición de iPrimo
        vectorPrincipal = new Lista[primos[iPrimo]];
        // Crea una lista en cada posición del array
        for (int i = 0; i < vectorPrincipal.length; i++) {
            vectorPrincipal[i] = new Lista<ClaveValor>();
        }

        size = 0;
        // Pasamos los elementos de la tabla actual a la nueva
        for (int i = 0; i < oldVector.length; i++) {
            while (oldVector[i].getLenght() > 0) {
                ClaveValor item = (ClaveValor) oldVector[i].sacarDato(0);
                insertar(item.clave, item.valor);
            }
        }
    }

    private void primosPorDefecto() {
        String[] s = io.lineasFichero("src\\resources\\listaPrimos");

        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }

        primos = nums;
    }

    @Override
    public String toString() {
        return "HashTable [factorCarga=" + factorCarga + ", size=" + size + ", vectorPrincipal="
                + Arrays.toString(vectorPrincipal) + "]";
    }

    public ClaveValor get(String clave) {
        return vectorPrincipal[funcionHash(clave)].getDato(new ClaveValor(clave, null));
    }

    public ClaveValor borrar(String clave) {
        ClaveValor res = vectorPrincipal[funcionHash(clave)].sacarDato(new ClaveValor(clave, null));

        if (res != null)
            size--;

        // Comprueba, redispersión si es necesario y actualiza el parámetro
        factorCarga = (double) size / vectorPrincipal.length;
        if (factorCarga < FACTOR_CARGA_REDUCIR)
            redispersion(vectorPrincipal.length / 2);

        return res;
    }

    // ************************************************************************
    // * /Métodos override\
    // ************************************************************************

    // ************************************************************************
    // * /Setters & Getters\
    // ************************************************************************

}
