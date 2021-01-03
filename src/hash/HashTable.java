package hash;

import lab1jh.lista.*;

public class HashTable<Tipo> {
    // ************************************************************************
    // * /Atributos\ 
    private Lista<Integer> primos;
    private int[] principal;
    // * \Atributos/ 
    // ************************************************************************

    // ************************************************************************
    // * /Constructores\ 
    public HashTable(Lista<Integer> primos) {
        this.primos = primos;
        inicializar();
    }

    public HashTable(int[] primos) {
        this.primos = iniPrimos(primos);
        inicializar();
    }

    public HashTable() {
        int[] primos = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97 };
        this.primos = iniPrimos(primos);
        inicializar();
    }
    // * \Constructores/ 
    // ************************************************************************

    // ************************************************************************
    // * /Metodos internos\ 
    private void inicializar() {
        // TODO inciar atributos
    }

    private Lista<Integer> iniPrimos(int[] primos) {
        Lista<Integer> list = new Lista<>();
        for (int primo : primos) {
            list.addDato(primo);
        }
        return list;
    }

    // * \Metodos internos/ 
    // ************************************************************************

    // ************************************************************************
    // * /Metodos Publicos\ 
    // * \Metodos Publicos/ 
    // ************************************************************************

    // ************************************************************************
    // * /Metodos override\ 
    // * \Metodos override/ 
    // ************************************************************************

    // ************************************************************************
    // * /Setters & Getters\ 
    // * \Setters & Getters/ 
    // ************************************************************************

}
