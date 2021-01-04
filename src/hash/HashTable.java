package hash;

import java.util.Arrays;

import jh.lab1.lista.*;
import jh.util.io;

public class HashTable {
    private static final double factorCargaAumentar = 1; // Valor para redispersion (aumentar)
    private static final double factorCargaReducir = (double) 1 / 3; // Valor para redispersion inversa (reducir)
    private static final int primoInicial = 3;

    // /Atributos\
    private int[] primos;
    private int iPrimo;
    // Lista de listas de parejas clave:valor
    // He elegido un vector en vez de mi lista enlazada por que permite acceso
    // aleatorio
    private Lista<Par>[] vectorPrincipal;
    private int size;
    private double factorCarga;
    // ************************************************************************

    // class Pareja {
    // // Ambito de paquete. Sin setters y getters
    // String clave;
    // T valor;

    // public Pareja(String clave, T valor) {
    // this.clave = clave;
    // this.valor = valor;
    // }

    // }

    // ************************************************************************
    // * /Constructores\
    // public HashTable(Lista<Integer> primos) {
    // this.primos = primos;
    // inicializar();
    // }

    public HashTable(int[] primos) {
        this.primos = primos;
        inicializar();
    }

    public HashTable() {
        inicializar();
    }
    // ************************************************************************

    // ************************************************************************
    // * /Metodos internos\
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

        iPrimo = getIndicePrimo(primoInicial);

        // Dimensiona el vector al tamaño del primo en la poscion de iPrimo
        vectorPrincipal = new Lista[primos[iPrimo]];

        // Crea una lista en cada posión del array
        for (int i = 0; i < vectorPrincipal.length; i++) {
            vectorPrincipal[i] = new Lista<Par>();
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
    // * /Metodos Publicos\
    // ************************************************************************
    public boolean insertar(String clave, Object valor) {
        size++;
        Par item = new Par(clave, valor);
        vectorPrincipal[funcionHash(clave)].addDato(item);

        // Comprueba, redispersan si es necesario y actualiza el parametro
        factorCarga = (double) size / vectorPrincipal.length;
        if (factorCarga > factorCargaAumentar)
            redispersar(vectorPrincipal.length * 2);

        return true;
    }

    /**
     * Usa el propio String como clave
     * 
     * @param string
     * @return
     */
    public boolean insertar(String string) {
        return insertar(string, string);
    }

    @SuppressWarnings("unchecked")
    private void redispersar(int newSize) { // redispersion y redispersion inversa segun necesidad
        iPrimo = getIndicePrimo(newSize);

        // Guardamos referencia al vector acual
        Lista<Par>[] oldVector = vectorPrincipal;

        // Redimensionamos el vector al tamaño del primo en la poscion de iPrimo
        vectorPrincipal = new Lista[primos[iPrimo]];
        // Crea una lista en cada posión del array
        for (int i = 0; i < vectorPrincipal.length; i++) {
            vectorPrincipal[i] = new Lista<Par>();
        }

        size = 0;
        // Pasamos los elementos de la tabla acual a la nueva
        for (int i = 0; i < oldVector.length; i++) {
            while (oldVector[i].getLenght() > 0) {
                Par item = (Par) oldVector[i].sacarDato(0);
                insertar(item.clave, item.valor);
            }
        }
    }

    private double factorCarga() {
        double fc = (double) size / vectorPrincipal.length;
        if (fc > factorCargaAumentar) {
            redispersar(vectorPrincipal.length * 2);
        } else if (fc < factorCargaReducir) {
            redispersar(vectorPrincipal.length / 2);
        }
        return (double) size / vectorPrincipal.length;
    }

    // private double factorCarga() {
    // return size / principal.length;
    // }

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

    public Object get(String clave) {
        int code = funcionHash(clave);
        Par auxPar;
        Object ret = null;
        Lista<Par> auxLista = new Lista<>();
        while (vectorPrincipal[code].getLenght() > 0 && ret == null) {
            auxPar = vectorPrincipal[code].sacarDato(0);
            auxLista.addDato(auxPar);
            if (auxPar.clave.equals(clave))
                ret = auxPar.valor;
        }
        while (auxLista.getLenght() > 0) {
            vectorPrincipal[code].addDato(auxLista.sacarDato(auxLista.getLenght() - 1), 0);
        }
        return ret;
    }

    public boolean borrar(String clave) {
        int code = funcionHash(clave);
        Par auxPar;
        boolean ret = false;
        Lista<Par> auxLista = new Lista<>();
        while (vectorPrincipal[code].getLenght() > 0 && !ret) {
            auxPar = vectorPrincipal[code].sacarDato(0);
            if (!auxPar.clave.equals(clave))
                auxLista.addDato(auxPar);
            else {
                ret = true;
                size--;
            }
        }
        while (auxLista.getLenght() > 0) {
            vectorPrincipal[code].addDato(auxLista.sacarDato(auxLista.getLenght() - 1), 0);
        }

        // Comprueba, redispersan si es necesario y actualiza el parametro
        factorCarga = (double) size / vectorPrincipal.length;
        if (factorCarga < factorCargaReducir)
            redispersar(vectorPrincipal.length / 2);

        return ret;
    }

    // ************************************************************************
    // * /Metodos override\
    // ************************************************************************

    // ************************************************************************
    // * /Setters & Getters\
    // ************************************************************************

}
